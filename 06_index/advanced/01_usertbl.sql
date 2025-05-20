use sqldb;

-- usertbl의 내용 확인
select * from usertbl;

-- usertbl의 인덱스 목록 확인
show index from usertbl; -- PRIMARY KEY 하나 존재

-- usertbl의 데이터 크기와 인덱스의 크기 확인

show table status like 'usertbl';
-- 데이터 크기 : Data_length : 16384
-- 인덱스 크기 : Index_length : 0
    -- InnoDB는 PK 인덱스에 데이터를 같이 저장하는 클러스터형 인덱스를 사용하므로
    -- 이 경우 Index_length 는 보조 인덱스 크기만 보여줌.

-- usertbl의 addr 컬럼에 대해 idx_usertbl_addr이름으로 인덱스를 만들고, 인덱스 목록을 확인
create index idx_usertbl_addr on usertbl (addr);

analyze table usertbl;
-- 테이블에 대한 인덱스 통계 계산해서 쿼리 최적화 돕는 명령

-- usertbl의 상태를 출력하여 인덱스의 내용이 만들어졌는지 확인하고,
-- 내용이 없다면 실제 적용되도록 한 후, 인덱스의 크기를 확인하세요.
show table status like 'usertbl';
-- 데이터 크기 : Data_length : 16384
-- 인덱스 크기 : Index_length : 16384
-- => 인덱스가 생성됨.

-- ---------------------------------------------------------
-- birthYear 컬럼에 대해 idx_usertbl_birthYear 이름의 인덱스를 만드세요.
create index idx_usertbl_birthYear on usertbl (birthYear);
-- 에러가 난다면 그 이유를 설명하세요.

-- name 컬럼에 대해 idx_usertbl_name 이름의 인덱스를 만드세요
create index idx_usertbl_name on usertbl (name);

-- 생성된 인덱스 목록 확인
show index from usertbl;

-- ---------------------------------------------------
-- name 컬럼에 대한 보조 인덱스를 삭제하세요.
drop index idx_usertbl_name on usertbl;

-- name과 birthYear 컬럼 조합으로 idx_usertbl_name_birthYear 이름의 인덱스를 생성
create index idx_usertbl_name_birthYear on usertbl (name, birthYear);

-- 인덱스 목록 확인
show index from usertbl;

-- usertbl에서 앞에서 만든 인덱스를 삭제하세요.
drop index idx_usertbl_name_birthYear on usertbl;