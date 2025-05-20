use sqldb;

create table tbl5
(
    a int unique not null ,
    b int unique, -- b unique 키 -> unique 인덱스 생성 (중복불가, null 허용)
    c int unique, -- c unique 키 -> unique 인덱스 생성 (중복불가, null 허용)
    d int primary key -- > PRIMARY 클러스터형 인덱스 설정
);

-- tbl5이 가지고 있는 인덱스 조회
show index from tbl5;

