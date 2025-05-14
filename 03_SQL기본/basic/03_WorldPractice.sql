use world;
show tables;

--
select Population
from city
where CountryCode = 'KOR'
order by population desc;

--
select CountryCode, Population
from city
order by CountryCode,
         population desc;
--
select count(*)
from city
where CountryCode = 'KOR';

--
select Name
from city
where CountryCode in ('KOR','CHN','JPN');

--
select name
from city
where CountryCode = 'KOR' AND Population >= 1000000;

--
select Name
from city
where CountryCode = 'KOR'
order by Population desc
limit 10;

--
select Name
from city
where CountryCode = 'KOR' AND
      Population >= 1000000 AND
      Population <= 5000000;