show databases;
create database test;
use test;
show tables;
drop database test;

--How to remove duplicate rows from table?
delete from mytable
where id not in (
select min(id)
from mytable
group by col1, col2
having count(*) =1);

--second highest salary of Employee
select max(salary) from employee where salary not in (select max(salary) from employee);


--Finding duplicate values in a SQL table
select name, email, count(*)
from employee
group by name, email
having count(*) > 1;

--3rd highest salary
select distinct salary
from (select salary from employee order by salary desc limit 3)
order by salary asc limit 1 offset 2;

--Deleting dependent entries in different tables

create table employees(id int primary key, name varchar(255), salary decimal(10,20));

create table departments(id int primary key, name varchar(255), manager_id int , foreign key (manager_id) references(id) on delete cascade);

create table salary(id int primary key, employee_id int, salary decimal(10,2), foreign key (employee_id) references (id) on delete cascade);

--2nd highest salary
select distinct salary
from (select salary from employee order by salary desc limit 2)
order by salary asc limit 1 offset 1;