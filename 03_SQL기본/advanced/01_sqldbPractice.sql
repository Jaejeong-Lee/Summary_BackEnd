use sqldb;

--
select
    userID as '사용자 아이디',
    SUM(amount) as '총 구매 개수'
from buytbl
group by userID;

--
select
    userID as '사용자 아이디',
    SUM(price * amount) as '총 구매액'
from buytbl
group by userID;

--
select
    AVG(amount) as '평균 구매 개수'
from buytbl;

--
select
    userID,
    AVG(amount) as '평균 구매 개수'
from buytbl
group by userID;

--
select
    name,
    height
from usertbl
where height = (select MAX(height) from usertbl) or height = (select MIN(height) from usertbl);

--
select
    count(*) as '휴대폰이 있는 사용자'
from usertbl
where mobile1 != 'null';

--
select
    userID as 사용자,
    SUM(price * amount) as '총 구매액'
from buytbl
group by userID;

--
select
    userID as 사용자,
    SUM(price * amount) as '총 구매액'
from buytbl
group by userID
having SUM(price * amount) >= 1000;
