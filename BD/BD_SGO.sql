-- drop database sgo;
create database sgo;

use sgo;

-- select * from clientes;

create table clientes(
	idCli int auto_increment not null primary key,
	nome varchar(150) not null,
<<<<<<< HEAD
	cpf varchar(11),
	cnpj varchar(14),
=======
	cpf varchar(11) ,
	cnpj varchar(14) ,
>>>>>>> 985199c9d2654f11bec90adcc914c28d82fd732f
    fone varchar(11) not null,
    email varchar(150) not null,
    bairro varchar(150) not null,
    numero varchar(8) not null, 
    rua varchar(150) not null
); 

create table funcionarios(
	idFunc int auto_increment not null primary key,
	nome varchar(150) not null,
    cpf varchar(11) not null,
    cargo int not null,
    fone varchar(50) not null,
    email varchar(150) not null,
    salario numeric(8,2) not null,
    bairro varchar(150) not null,
    numero varchar(8) not null, 
    rua varchar(150) not null
);

create table obrasEServicos(
	idObra int auto_increment not null primary key,
	descricao varchar(150) not null,
    bairro varchar(150) not null,
    numero varchar(8) not null, 
    complemento varchar(150) not null,
    rua varchar(150) not null,
    cidade int not null,
    cliente int,
	foreign key(cliente) references clientes(idCli)
);

create table trabalhos(
	idTrab int auto_increment not null primary key,
	dataInicio date not null,
	dataTermino date not null,
	andamento int not null,
	ultimaModificacao date,
	obraEServico int,
	foreign key(obraEServico) references obrasEServicos(idObra)
);

create table fornecedores(
	idForn int auto_increment not null primary key,
	nome varchar(150) not null,
    fone varchar(11) not null,
    email varchar(150) not null,
    bairro varchar(150) not null,
    numero varchar(8) not null, 
    rua varchar(150) not null
);

create table materiais(
	idMate int auto_increment not null primary key,
	nome varchar(50) not null,
    qtd int not null,
    valor varchar(50) not null,
    descricao varchar(150) not null
);	

create table empresa(
	idEmpr int auto_increment not null primary key,
	cnpj varchar(14) not null unique,
	nome varchar(100) not null,
	fone varchar(11) not null,
	email varchar(150) not null,
	bairro varchar(150) not null,
    numero varchar(8) not null, 
    rua varchar(150) not null
);

create table pedidos(
	id int auto_increment not null primary key,
	data date,
	fornecedor int,
	foreign key(fornecedor) references fornecedores(idForn)
);

create table listafuncionarios (
	idLF int auto_increment not null primary key,
    funcionario int,
    trabalho int,
    foreign key(funcionario) references funcionarios(idFunc), 
    foreign key(trabalho) references trabalhos(idTrab)
);

create table listamaterial (
	idLM int auto_increment not null primary key,
    material int,
    qtd int,
    foreign key(material) references materiais(idMate)    
);

-- insert into funcionarios(idFunc,cpf,nome,fone,cargo,email,bairro,numero,rua,salario) values (1,'11111111111','Januária','38991586654',1,'gfdg','gfdg','dfg','fdsfsd',1222);