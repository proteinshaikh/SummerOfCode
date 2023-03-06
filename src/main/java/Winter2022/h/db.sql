--3rd highest salary
select distinct salary
from (select salary from employee order by salary desc limit 3)
order by salary asc limit 2 offset 1;


select salary
from ( select salary, DENSE_RANK() OVER  (order by  salary desc) as rank from employees)
where rank =5;

--DENSE_RANK() is a ranking function in Oracle SQL that assigns a rank to each row in a result set based on the values in one or more columns.
--The rank values start at 1 for the highest value, and increment by 1 for each unique value encountered.
--In case of ties, the same rank value is assigned to all tied rows, and the next rank value is skipped.

--The DENSE_RANK() function is similar to the RANK() function, but it does not skip rank values for ties.
--This means that if there are ties for a particular rank value, the next rank value will be incremented by the number of tied rows, instead of just 1.

--group by
SELECT city, COUNT(*)
FROM table_name
GROUP BY city;
