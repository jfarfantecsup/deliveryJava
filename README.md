"# deliveryJava" 

create database deliveryDB;
use deliveryDB;

create table usuario(
 id int primary key AUTO_INCREMENT,
 login varchar(20),
 clave varchar(20),
 tipo varchar(1),
 estado varchar(1)
);

insert into usuario(login,clave,tipo,estado) 
values ('jfarfan','123','P','A');
