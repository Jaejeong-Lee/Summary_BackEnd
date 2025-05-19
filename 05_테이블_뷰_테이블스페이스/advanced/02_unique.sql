use tabledb;

drop table if exists buyTBL;
drop table if exists userTBL;

create table userTBL (
    userID char(8) not null primary key,
    name varchar(10) not null,
    birthYear int not null,
    email char(30) unique
);

desc userTBL;