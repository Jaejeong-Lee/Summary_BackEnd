use tabledb;

drop table if exists buytbl;
drop table if exists usertbl;

create table usertbl (
    userID char(8) not null,
    name varchar(10) not null,
    birthyear int not null,

    -- constraint : 제약조건을 명시적으로 이름 붙여 정의
    -- primary key [기본키제약조건이름] (기본키로 지정할 칼럼)
    constraint primary key PK_userTBL_userID(userID)
);
desc usertbl;

create table prodTbl (
    prodCode char(3) not null,
    prodID char(4) not null,
    prodDate DATETIME not null ,
    proCur char(10),

    -- 복합키 설정
    constraint primary key PK_prodTbl_prodCode_prodID (prodCode, prodID)
);

desc prodtbl;