--Here are a few ways to remove duplicate rows from a table in SQL:

--Using SELECT DISTINCT:


SELECT DISTINCT *
FROM table_name;


--This will return unique rows based on all columns in the table.

--Using GROUP BY:


SELECT *
FROM table_name
GROUP BY column1, column2;
