use sqldb;

create table tbl4
(
    -- -> 클러스터형 인덱스로 생성됨
    -- MySQL의 innoDB의 경우 테이블에 pk가 없을 경우
    -- not null + unique 제약 조건이 있는 첫번째 칼럼을 클러스터형 인덱스로 삼는다.
    -- not null + unique 제약조건의 칼럼이 없을 경우 내부적으로 숨겨진 시스템 행 id를 사용한다.

    a int unique not null ,
    b int unique, -- b unique 키 -> unique 인덱스 생성 (중복불가, null 허용)
    c int unique, -- c unique 키 -> unique 인덱스 생성 (중복불가, null 허용)
    d int
);

-- tbl4이 가지고 있는 인덱스 조회
show index from tbl4;

