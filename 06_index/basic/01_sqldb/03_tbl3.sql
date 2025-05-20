use sqldb;

create table tbl3
(
    a int unique, -- a unique 키 -> unique 인덱스 생성 (중복불가, null 허용)
    b int unique, -- b unique 키 -> unique 인덱스 생성 (중복불가, null 허용)
    c int unique, -- c unique 키 -> unique 인덱스 생성 (중복불가, null 허용)
    d int
);

-- tbl3이 가지고 있는 인덱스 조회
show index from tbl3;

