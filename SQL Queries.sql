create database SQLQueries;
use SQLQueries;
set SQL_SAFE_UPDATES = 0;

create table Department(
Dept_Id int primary key,
Dept_Name varchar(25)
);

create table Employee(
Emp_Id int primary key,
Emp_Name varchar(30),
Doj date,
Salary int,
Dept_Id int,
Job_Title varchar(30),
Manager varchar(20),
Location varchar(15),
Email varchar(50) ,
Phone_No long not null,
foreign key (Dept_Id) references Department(Dept_Id)
);

create table Project(
Project_A boolean,
Project_B boolean,
Emp_Id int,
foreign key (Emp_Id) references Employee(Emp_Id)
);

insert into Department values(1,'IT'),(2,'HR'),(3,'Finance');

insert into Employee values (1,'Anu','2020-10-24',60000,1,'HR Specialist','Ritheesh','India','anu123@gmail.com',7697675287),
(2,'Saranya','2019-05-15',40000,2,'Automation Test Engineer','Arun','New York','saranya20@gmail.com',6997785287),
(3,'Ilamathi','2014-09-05',55000,3,'Financial Planner','Pallavi','Japan',"ilamathi25@gmail.com",6381616938),
(4,'Sweatha','2023-08-27',25000,2,'Cloud Computing Engineer',null,'Canada','sweatha0606@gmail.com',7859732873),
(5,'Shreemathi','2015-05-06',26000,1,'HR Coordinator','Ritheesh','New York','shreenatarajan@gmail.com',7975767667);

insert into Project values (true,false,1),(true,true,2),(false,false,3),
(false,true,4),(false,false,5);

select * from Department;
select * from Employee;
select * from Project;

                                        -- Basic Queries
-- 1. Write a query to display all rows and columns from the employees table.
select * from Employee as Employee_Data;

-- 2. Retrieve only the name and salary of all employees from the employees table.
select Emp_Name, Salary from Employee;

-- 3. Write a query to find all employees whose salary is greater than 50,000.
select Emp_Name from Employee where Salary > 50000;

-- 4. List all employees who joined the company in the year 2020.
select Emp_Name from Employee where Year(DOj) = 2020;

-- 5. Retrieve the details of employees whose names start with the letter 'A'.
select * from Employee where Emp_Name like 'A%';

                                   -- Aggregate Functions
-- 6. Write a query to calculate the average salary of all employees.
select avg(Salary) as Average_Salary from Employee;

-- 7. Find the total number of employees in the company.
select count(*) as Employee_Count from Employee;

-- 8. Write a query to find the highest salary in the employees table.
select max(Salary) as Highest_Salary from Employee;

-- 9. Calculate the total salary paid by the company for all employees.
select sum(Salary) as Total_Salary_Paid from Employee;

-- 10. Find the count of employees in each department.
select Dept_Id,count(*) as Each_Dept_Count from Employee group by Dept_Id;

												-- Joins
-- 11.	Write a query to retrieve employee names along with their department names (using employees and departments tables).
select e.Emp_Name,d.Dept_Name from Employee e inner join Department d on d.Dept_Id = e.Dept_Id;

-- 12.	List all employees who have a manager (self-join on employees table).
select e.Emp_Name, e2.Manager from Employee e
join Employee e2 ON e2.Emp_Id=e.Emp_Id where e2.Manager IS NOT NULL;

-- 13.	Find the names of employees who are working on multiple projects (using employees and projects tables).
select e.Emp_Name from Employee e join Project p on e.Emp_Id = p.Emp_Id 
where p.Project_A is not null and p.Project_B is not null;

-- 14.	Write a query to display all projects and the employees assigned to them.
select e.Emp_Name, p.Project_A, p.Project_B from Employee e join Project p on e.Emp_Id = p.Emp_Id 
where p.Project_A = 1 or p.Project_B = 1 or (p.Project_A = 1 and p.Project_B = 1);

-- 15.	Retrieve the names of employees who do not belong to any department.
select * from Employee e join Project p on e.Emp_Id = p.Emp_Id WHERE p.Project_A is NULL or p.Project_B is NULL;

                                               -- Sub Queries
-- 16.	Write a query to find the employees with the second-highest salary.
select Salary from Employee where Salary < (select max(Salary) from Employee) order by Salary desc limit 1;

-- 17.	Retrieve the names of employees whose salary is above the department average salary.
select e.Emp_Name from Employee e where e.Salary > (select avg(e2.Salary) from Employee e2 where  e2.Dept_Id = e.Dept_Id group by e2.Dept_Id);

-- 18.	Find employees who earn more than the average salary of the entire company.
select Emp_Name,Salary from Employee where Salary > (select avg(Salary) from Employee);

insert into Employee values (7,'Ashwini','2022-05-16',40000,3,'Financial Planner','Pallavi','India','ashwini27@gmail.com',8990656766);
insert into Project values(true,false,7);

-- 19.	Write a query to find the department with the highest number of employees.
select d.Dept_Name, count(e.Emp_Id) as Employee_Count from Department D join 
Employee e on d.Dept_Id = e.Dept_Id group by d.Dept_Name order by Employee_Count desc limit 1;

-- 20.	List all employees who work in a department located in 'New York'.
select Emp_Name from Employee where Location in ('New York');

                                         -- Set Operators
-- 21.	Write a query to find employees who work in either the 'HR' or 'Finance' department.
select emp.Emp_Name,dep.Dept_Name from Employee emp join 
Department dep on emp.Dept_Id = dep.Dept_Id where dep.Dept_Name = 'HR' or dep.Dept_Name = 'Finance';

-- 22.	Retrieve the names of employees who are working on both Project A and Project B.
select emp.Emp_Name as Working_On_Two_Projects from Employee emp join 
Project pro on emp.Emp_Id = pro.Emp_Id where pro.Project_A = 1 and pro.Project_B = 1;

-- 23.	Find employees who are not assigned to any project.
select emp.Emp_Name as Not_Working_On_Projects from Employee emp join 
Project pro on emp.Emp_Id = pro.Emp_Id where pro.Project_A = 0 and pro.Project_B = 0;

-- 24.	Write a query to get all unique job titles across all departments
select distinct(Job_Title) from Employee;

create table Former_Employees(
Emp_Id int primary key,
Emp_Name varchar(30),
Doj date,
Salary int,
Dept_Id int,
Job_Title varchar(30),
Manager varchar(20),
Location varchar(15),
Email varchar(50) ,
Phone_No long not null,
foreign key (Dept_Id) references Department(Dept_Id)
);

insert into Former_Employees values
(3,'Ilamathi','2014-09-05',55000,3,'Financial Planner','Pallavi','Japan',"ilamathi25@gmail.com",6381616938),
(5,'Shreemathi','2015-05-06',28600,1,'HR Coordinator','Ritheesh','New York','shreenatarajan@gmail.com',7975767667);

-- 25.	Combine two tables (employees and former_employees) and remove duplicates.
select * from Employee union select * from Former_Employees as combined_Table;

                                              -- DML and DDL
-- 26.	Write a query to add a new employee to the employees table.
insert into Employee values (6,'Shalini','2024-06-06',20000,3,'Financial Planner','Pallavi','India','shalinismile@gmail.com',7678656766);
insert into Project values(true,false,6);

-- 27.	Update the salary of all employees in the 'IT' department by 10%.
update Employee set Salary = (Salary*1.10) where Dept_Id in(select Dept_Id from Department where Dept_Name = 'IT');

-- 28.	Delete all employees who have not worked for more than 5 years.
delete from Employee where Doj <= CURDATE() - INTERVAL 4 YEAR;

-- 29.	Create a new table departments_backup with the same structure as the departments table.
create table Department_backups(
Dept_Id int primary key,
Dept_Name varchar(25));

-- 30.	Drop the temporary_data table from the database.
truncate table Employee;

                                               -- Constraints 
-- 31. Add a primary key to the employees table.
-- Implemented while creating the table

-- 32.	Write a query to create a foreign key between employees and departments tables.
-- Implemented while creating the table

-- 33. Add a unique constraint to the email column in the employees table.
alter table Employee add constraint unique(Email);

-- 34.	Write a query to check all constraints applied on the employees table.
select CONSTRAINT_NAME,CONSTRAINT_TYPE FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
where TABLE_NAME = 'Employee';

-- 35.	Remove the NOT NULL constraint from the phone_number column in the employees table.
alter table Employee modify column Phone_No long;