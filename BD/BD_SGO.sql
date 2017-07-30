-- drop database sgo;
create database sgo;

use sgo;

-- select * from clientes;

create table clientes(
	idCli int auto_increment not null primary key,
	nome varchar(150) not null,
	cpf varchar(11) not null,
	cnpj varchar(14) not null,
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
    idCliente int
);

create table trabalhos(
	idTrabalhos int auto_increment not null primary key,
	dataInicio varchar(150) not null,
    previsaoTermino varchar(150) not null,
    situacao int not null,
    ultimaModificacao date,
    idCliente int
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

-- insert into funcionarios(idFunc,cpf,nome,fone,cargo,email,bairro,numero,rua,salario) values (1,'11111111111','Januária','38991586654',1,'gfdg','gfdg','dfg','fdsfsd',1222);