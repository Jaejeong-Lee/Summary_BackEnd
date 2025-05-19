use employees;

drop view EMPLOYEES_INFO;

-- 다음 정보를 가지는 직원 정보를 출력하는 EMPLOYEES_INFO 뷰를 작성하세요
create view EMPLOYEES_INFO as
select e.emp_no,
       e.birth_date,
       e.first_name,
       e.last_name,
       e.gender,
       e.hire_date,
       title,
       t.from_date as t_from,
       t.to_date as t_to,
       s.salary,
       s.from_date as s_from,
       s.to_date as s_to
from employees e
         join titles t on e.emp_no = t.emp_no
         join salaries s on e.emp_no = s.emp_no;

select * from EMPLOYEES_INFO;

-- EMPLOYEES_INFO 뷰에서 재직자의 현재 정보만 출력하세요.
select *
from EMPLOYEES_INFO
where t_to = '9999-01-01' and s_to = '9999-01-01';

-- 다음 정보를 가지는 부서 정보를 출력하는 EMP_DEPT_INFO 뷰를 작성하시오.

create view EMP_DEPT_INFO as
select e.emp_no, d.dept_no, dept_name, from_date, to_date
from employees e
left outer join dept_emp de on e.emp_no = de.emp_no
left outer join departments d on de.dept_no = d.dept_no;

select * from EMP_DEPT_INFO;

-- EMP_DEPT_INFO로 현재 재직자의 부서 정보를 출력하세요.
select *
from EMP_DEPT_INFO
where to_date = '9999-01-01';