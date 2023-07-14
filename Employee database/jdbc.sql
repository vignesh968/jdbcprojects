create database jdbcdemo;
use jdbcdemo;
create table employee(emp_id INT primary KEY,ename varchar(30),salary int);
insert into employee values(1,"ram",10000);
insert into employee values(2,"vicky",400000);
select * from employee;

delimiter $$
create procedure GetEmp()
begin
	select * from employee;
end$$
delimiter ;
	
    

delimiter $$
create procedure GetEmpById(in id int)
begin
	select * from employee where emp_id=id;
end$$
delimiter ;