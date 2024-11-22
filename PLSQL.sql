create database tasks;
use tasks;
create table Products(
Product_Id int primary key,
Product_Name varchar(25),
Qty int,
Price int,
Category varchar(15),
Product_Purchased_Date date
);
insert into Products values
(1,'Mobile',7,15000,'Electronics','2021-12-11'),
(2,'Mobile Charger',5,1000,'Electronics','2021-10-17'),
(3,'Office Chair',10,3000,'Furniture','2022-02-15'),
(4,'Office Table',15,6000,'Furniture','2023-07-05'),
(5,'Laptop',20,40000,'Electronics','2024-03-03'),
(6,'Laptop Charger',16,4000,'Electronice','2024-10-07'),
(7,'Pen drive',4,400,'Electronics','2024-11-20');
select * from Products;

/* 1 create product table and it takes price as an input and returns “Expensive” if price >10000,
 “Cheap” if price <5000 cheap and “Affordable” if price between 5000 and 10000. */
delimiter $$
create function getUpdateStatus(prod_Id int) returns varchar(100)
deterministic
begin 
declare productPrice int;
declare result varchar(100);
select Price into productPrice from Products where Product_Id = prod_Id;
If productPrice > 10000 then
 set result := 'Expensive';
else if productPrice > 10000 and productPrice < 5000 then
 set result := 'Affordable';
else if productPrice < 5000 then
 set result := 'Cheap';
else
 set result := 'Enter Correctly';
end if;
end if;
return result;
end;
delimiter ;
select getUpdateStatus(3);

-- 2 Create procedure that takes product id as input and returns details of that product details
delimiter $$
create procedure getDetailsOfProducts(IN Id int)
begin
select * from products where Product_Id = Id;
end; $$ 
delimiter ;
call getDetailsOfProducts(2);

/* 3 Create function takes price as an argument and 
 returns details of the product whose price is greater than than the price input parameter */
delimiter $$
create function getDetails(prod_price int)
returns varchar(200)
deterministic 
begin 
declare productDetails varchar(300);
 select concat(Product_Id,' ',Product_Name,' ', Qty,' ', Price,' ',Category,' ',Product_Purchased_Date) 
 into productDetails from products where price > prod_price limit 1; 
return productDetails;
end $$ 
delimiter ;
SELECT getDetails(400);

-- 4 create a trigger that displays the count of rows after inserting a new record in products table 
create table CountOfProducts (
prod_count int default 7);
select prod_count from CountOfProducts;
insert into CountOfProducts(prod_count) values(0);
delimiter $$
create trigger CountProduct after insert on Products
for each row
begin
update CountOfProducts
set prod_count = prod_count+1;
end $$
delimiter ;
-- set SQL_SAFE_UPDATES = 0;
insert into products values (8,'Key board',5,2500,'Electronics','2023-08-30');
insert into products values (9,'Key board',5,2500,'Electronics','2023-08-30');
select * from CountOfProducts;

-- 5 create a view that displays the details of Products from Furniture Category and price greater than 1000
delimiter $$;
create view Category as
select * from Products where Price > 1000 and Category = 'Furniture';
select * from Category;
end ;
delimiter;

-- 6 write a procedure that returns the details of products which will be purchased in this year 
delimiter $$
create procedure PurchasedDate(in purYear int)
begin
select * from Products where year(Product_Purchased_Date) = purYear;
end $$
delimiter ;
call PurchasedDate(2024);

-- 7 create a view that displays the details of highest product price
delimiter $$
create view HighestPrice as 
select * from Products where Price = (select max(Price) from Products);
select * from HighestPrice;
end ;
delimiter;




