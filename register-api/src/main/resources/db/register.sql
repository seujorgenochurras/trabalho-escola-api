create database register;
use register;

create table cep(
id varchar(10) primary key not null,
city varchar(100) not null,
state varchar(100) not null,
street_name varchar(100) not null,
neighborhood varchar(100) not null
);

create table simple_students(
uuid varchar(36)primary key not null,
name varchar(100) not null,
birth_date date not null,
cep_fk varchar(10) not null,
foreign key (cep_fk) references cep(id)
);
select * from simple_students;
select * from cep;
