drop database if exists employees;
create database employees;
use employees;

drop table if exists branch;
create table branch(
	id int not null auto_increment,
    name varchar(50),
    primary key(id)
);


drop table if exists employee;
create table employee(
	id int not null auto_increment,
    name varchar(50),
    national_id varchar(14),
    age int,
    branch_id int,
    primary key(id),
    unique(national_id),
    constraint employee_branch_fk foreign key(branch_id) references branch(id)
);


DROP USER if exists 'essam'@'localhost' ;
CREATE USER 'essam'@'localhost' IDENTIFIED BY 'essam';

GRANT ALL PRIVILEGES ON employees.* TO 'essam'@'localhost';