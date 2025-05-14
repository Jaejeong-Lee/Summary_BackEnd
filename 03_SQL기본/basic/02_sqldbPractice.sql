use sqldb;

-- 1.
select *
from usertbl
where name = '김경호';

select *
from usertbl
where birthYear >= 1970 AND height >= 182;

-- 2.
select *
from usertbl
where height BETWEEN 180 AND 183;

select *
from usertbl
where addr = '경남' or addr ='전남' or addr ='경북';

select *
from usertbl
where name LIKE '김%';

-- 3. 서브쿼리 문제
select
    name,
    height
from usertbl
where height > (select height from usertbl where name = '김경호' )

-- 4.
select *
from usertbl
order by mDate asc;

select *
from usertbl
order by mDate desc;

select *
from usertbl
order by
    height desc,
    name desc;

-- 5.
select distinct addr
from usertbl
order by addr asc;