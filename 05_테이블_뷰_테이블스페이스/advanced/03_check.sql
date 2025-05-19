use tabledb;

drop table if exists userTBL;

create table userTBL (
    userID char(8) not null primary key,
    name varchar(10),
    birthYear smallint,
    email char(30),

    check (birthYear between 1900 and 2300)
);

desc userTBL;