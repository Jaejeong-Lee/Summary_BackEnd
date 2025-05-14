use world;

--
select SUM(Population)
from city
where CountryCode = 'KOR';

--
select MIN(Population) as 최소값
from city
where CountryCode = 'KOR';

--
select AVG(Population)
from city
where CountryCode = 'KOR';

--
select MAX(Population) as 최대값
from city
where CountryCode = 'KOR';

-- Name 칼럼의 글자수 표시
select CHAR_LENGTH(name)
from country
group by Code;

-- LEFT(), UPPER() 함수
select left(UPPER(name),3)
from country;

--
select ROUND(LifeExpectancy,1)
from country;