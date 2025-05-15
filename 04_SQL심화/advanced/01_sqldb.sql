USE sqldb;
CREATE TABLE stdtbl
(
    stdName VARCHAR(10) NOT NULL PRIMARY KEY,
    addr    CHAR(4)     NOT NULL
);

CREATE TABLE clubtbl
(
    clubName VARCHAR(10) NOT NULL PRIMARY KEY,
    roomNo   CHAR(4)     NOT NULL
);

CREATE TABLE stdclubtbl
(
    num      int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    stdName  VARCHAR(10)        NOT NULL,
    clubName VARCHAR(10)        NOT NULL,
    FOREIGN KEY (stdName) REFERENCES stdtbl (stdName),
    FOREIGN KEY (clubName) REFERENCES clubtbl (clubName)
);
INSERT INTO stdtbl
VALUES ('김범수', '경남'),
       ('성시경', '서울'),
       ('조용필', '경기'),
       ('은지원', '경북'),
       ('바비킴', '서울');
INSERT INTO clubtbl
VALUES ('수영', '101호'),
       ('바둑', '102호'),
       ('축구', '103호'),
       ('봉사', '104호');
INSERT INTO stdclubtbl
VALUES (NULL, '김범수', '바둑'),
       (NULL, '김범수', '축구'),
       (NULL, '조용필', '축구'),
       (NULL, '은지원', '축구'),
       (NULL, '은지원', '봉사'),
       (NULL, '바비킴', '봉사');

-- --------------------------------
/*
 - 3개 이상 테이블 조인
 - 각 테이블은 관계가 있어야 함. 조인 조건을 명확히 설정해야 함

 작동 순서
 1. 첫번째 테이블과 두번째 테이블 먼저 조인
 2. '1번의 결과 테이블'과 세번째 테이블이 조인
 -- 각 조인마다 on으로 조건을 지정해야 함
 */
#  학생테이블, 동아리테이블, 학생동아리 테이블을 이용해서
#  학생을 기준으로 학생이름/지역/가입한 동아리/ 동아리방을 출력하세요.
select s.stdName   as 학생이름,
       sc.clubName as 동아리명,
       c.roomNo    as 동아리방
from stdtbl s
         join stdclubtbl sc
              on s.stdName = sc.stdName
         join clubtbl c
              on sc.clubName = c.clubName
order by sc.clubName;


-- 동아리를 기준으로 가입한 학생 목록 출력
-- 출력정보: clubName, roomNo, stdName, addr
select sc.clubName, c.roomNo, sc.stdName, s.addr
from stdclubtbl sc
         left outer join clubtbl c
                         on sc.clubName = c.clubName
         left outer join stdtbl s
                         on s.stdName = c.clubName
order by sc.clubName;
-- ------------------

USE sqldb;

CREATE TABLE empTbl
(
    emp     CHAR(3),
    manager CHAR(3),
    empTel  VARCHAR(8)
);

INSERT INTO empTbl
VALUES ('나사장', NULL, '0000');
INSERT INTO empTbl
VALUES ('김재무', '나사장', '2222');
INSERT INTO empTbl
VALUES ('김부장', '김재무', '2222-1');
INSERT INTO empTbl
VALUES ('이부장', '김재무', '2222-2');
INSERT INTO empTbl
VALUES ('우대리', '이부장', '2222-2-1');
INSERT INTO empTbl
VALUES ('지사원', '이부장', '2222-2-2');
INSERT INTO empTbl
VALUES ('이영업', '나사장', '1111');
INSERT INTO empTbl
VALUES ('이한영', '이영업', '1111-1');
INSERT INTO empTbl
VALUES ('최정보', '나사장', '3333');
INSERT INTO empTbl
VALUES ('윤차장', '최정보', '3333-1');
INSERT INTO empTbl
VALUES ('이주임', '윤차장', '3333-1-1');

-- '우대리'의 상관 연락처 정보 확인
select emp as 부하직원, manager as 직속상관, empTel as 직속상관연락처
from emptbl
where emp = '우대리';

-- ------------심화 2-------------
use employees;

-- 현재 재직 중인 직원의 정보를 출력하세요

-- ○ 출력항목: emp_no, first_name, last_name, title
select e.emp_no, first_name, last_name, title
from employees e
         join titles t
              on e.emp_no = t.emp_no
where to_date = '9999-01-01'
limit 4;

-- ○ 출력항목:  직원의 기본정보 모두, title, salary

select e.emp_no,
       birth_date,
       first_name,
       last_name,
       gender,
       hire_date,
       title,
       salary
from employees e
         join titles t
              on e.emp_no = t.emp_no
         join salaries s
              on e.emp_no = s.emp_no
where s.to_date = '9999-01-01'
limit 7;

-- 출력항목:  emp_no, first_name, last_name, department
-- ○ 정렬: emp_no 오름 차순
select e.emp_no, first_name, last_name, d.*
    from employees e
        join dept_emp de
            on de.emp_no = e.emp_no
        join departments d
            on de.dept_no = d.dept_no
order by emp_no
limit 12;

-- 부서별 재직중 직원의 수
-- 출력항목: 부서번호, 부서명, 인원수
-- ○ 정렬: 부서번호 오름차순
select d.dept_no, d.dept_name, count(*)
from dept_emp de
         join departments d
              on de.dept_no = d.dept_no
where de.to_date = '9999-01-01'
group by d.dept_no, d.dept_name
order by d.dept_no;
/* 주의) 집계함수(ex. count())를 사용할 때에는 group by 를 사용해주어야 함 */

-- 직원번호가 10209인 직원의 부서 이동 히스토리를 출력하세요.
-- ○ 출력항목: emp_no, first_name, last_name, dept_name, from_date, to_date
select de.emp_no, first_name, last_name, dept_name, from_date, to_date
from employees e
    join dept_emp de
        on e.emp_no = de.emp_no
    join departments d
        on de.dept_no = d.dept_no
where e.emp_no = '10209';

