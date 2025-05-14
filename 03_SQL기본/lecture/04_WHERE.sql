-- WHERE
-- 특정 조건에 맞는 레코드(데이터)만을 선택하는 데 사용됨

-- [ = ] 같음 연산자를 사용한 where절
select
    *
from
    employees
where
    gender = 'M' -- 성별이 'M'인 애들만
limit 5;

-- select 에 담지 않더라도 다른 컬럼의 속성으로 조건을 걸 수 있음
select
    first_name,
    last_name,
    gender
from
    employees
where
    gender != 'M' -- 성별이 'M'이 아닌 애들만
#     gender <> 'M' -- 성별이 'M'이 아닌 애들만
limit 5;

-- AND 연산자 : 둘 다 true여야 true / 하나라도 false면 false
-- OR 연산자 : 둘 중 하나라도 true면 true
-- AND가 OR보다 우선순위가 높다.
-- 1 : true / 0 : false
select 1 or 0 and 0; -- 1로 출력
select (1 or 0) and 0; -- 0로 출력

select
    emp_no,
    first_name,
    last_name,
    gender
from
    employees
where
    gender <> 'M' AND
    emp_no < '10050'; -- emp_no 이 10050보다 작고, gender가 'M'이 아닌 조건

-- BETWEEN
select
    *
from
    employees
where
    emp_no >= 10050 AND
    emp_no <= 10060;

/*
BETWEEN 연산자
- 경계값을 '포함'한 사잇값을 포함
*/

select
    *
from
    employees
where
#     emp_no between 10050 AND 10060;
    emp_no NOT between 10050 AND 499995; -- 부정표현 (경계값 및 사잇값 포함 안 한 나머지)

/*
LIKE 연산자
- 특정 패턴과 일치하는 행을 검색

패턴
- % : 0개 이상의 문자를 나타냄
    ex) '%apple%' -> apple이 포함된 모든 문자열
- _(언더바) : 1개의 문자를 나타냄
    ex) 'a_k'는 a로 시작하고 k로 끝나는 세글자 문자열을 의미
*/
select
    first_name
from employees
where
    first_name LIKE 'Aa%'; -- Aa로 시작하는 모든 first_name이 출력됨

select
    first_name
from employees
where
    first_name LIKE 'Aa__d'; -- first_name이 Aa로 시작하고 d로 끝나면서 5글자인 모든 데이터

/*
IN 연산자
- 특정 열의 값이 지정된 목록 중 하나와 일치하는지 확인하는데 사용
*/
select
    *
from
    employees
where
    emp_no in (1,2,3,4,5);