use tabledb;

drop table if exists userTBL;

create table userTBL (
    userID char(8) not null primary key,
    name varchar(10) not null,
    birthYear int not null default -1,
    addr char(2) not null default '서울',
    mobile1 char(3),
    mobile2 char(8),
    height smallint default 170,
    mDate Date
);
desc userTBL;
-- 기본값 추가를 확인할 수 있는 데이터 추가하기
insert into userTBL (userID, name, birthYear, addr, mobile1, mobile2, height, mDate)
    value ('hong', '홍길동', default, default, 010, 12345678, default, NOW());

select * from usertbl;

-- mobile1 칼럼 삭제하기
ALter table userTBL drop column mobile1;

-- name 컬럼명 uName으로 변경
alter table userTBL rename column name to uName;

-- 기본키 제거
alter table userTBL drop primary key;
desc userTBL;