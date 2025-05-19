use tabledb;

drop table if exists buyTBL;
drop table if exists userTBL;
create table userTBL
(
    userID    char(8)     not null primary key,
    name      varchar(10) not null,
    birthyear int         not null
);

create table buyTBL
(
    num      int auto_increment not null primary key,
    userID   char(8)            not null,
    prodName char(10)           not null
    -- foreign key (userID) references userTBL (userID)
);

Alter table buyTBL
    add constraint fk_buyTBL_userID
        foreign key (userID) references userTBL (userID)
            on delete cascade
            on update cascade;

desc userTBL;
desc buyTBL;


# Alter table buyTBL drop foreign key buytbl_ibfk_1;
# Alter table userTBL drop foreign key fk_userTBL_userID;

-- 초기에 외래키 설정 시 자동 생성되는 제약조건명
-- ('[테이블명]_ibfk_번호') : 'buytbl_ibfk_1'
-- [HY000][3730] Cannot drop table 'usertbl' referenced by a foreign key constraint 'buytbl_ibfk_1' on table 'buytbl'.