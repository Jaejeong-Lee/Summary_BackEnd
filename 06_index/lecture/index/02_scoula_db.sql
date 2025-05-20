-- root 계정
create user 'scoula'@'%' identified by '1234';
create database scoula_db;
grant all privileges on scoula_db to 'scoula'@'%';

# -- scoula 계정
# use scoula_db;

