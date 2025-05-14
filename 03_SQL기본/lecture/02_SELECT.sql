-- SELECT
-- 특정 테이블에서 원하는 데이터를 조회할 수 있다.

select -- 조회해줘
    * -- 모든 컬럼을
from -- buytbl에서
    buytbl;

select
    userID,
    groupName
from buytbl;

select(5+5); -- 간단한 연산도 가능

select now(); -- 현재 시간 출력 가능

-- concat() : 문자 합치는 역할
-- as 별칭(alias) : 컬럼명 별칭으로 꾸밀 수 있음.
select concat('bear','안녕','kb') as '인 사';

-- usertbl의 name, mobile1, mobile2 를 조회
-- mobile1, mobile2는 붙여서 전화번호라는 컬럼으로 출력되어야 함

select
    name,
    concat(mobile1,mobile2) as 전화번호
from usertbl;