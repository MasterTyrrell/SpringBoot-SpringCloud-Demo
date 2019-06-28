create database db_propducts default charset utf8;
create table products(pid int not null primary key auto_increment,pname varchar(100),type varchar(50),price double ,createTime datetime);