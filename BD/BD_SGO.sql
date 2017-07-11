-- drop database sgo;
create database sgo;

use sgo;

-- select * from fornecedores;

/*create table empresa(
	idEmpresa int auto_increment not null,
	razaoSocial varchar(100) not null,
    cnpj varchar(150) not null,
    endereco varchar(8) not null, 
    fone varchar(150) not null,
    primary key(idEmpresa)
); */

create table funcionarios(
	idFunc int auto_increment not null primary key,
	nome varchar(150) not null,
    cpf varchar(11) not null,
    cargo varchar(50) not null,
    fone varchar(50) not null,
    email varchar(150) not null,
    salario numeric(4,2) not null,
    bairro varchar(150) not null,
    numero varchar(8) not null, 
    rua varchar(150) not null
);

/*create table obrasEServicos(
	idObra int auto_increment not null,
	descricao varchar(150) not null,
    bairro varchar(150) not null,
    numero varchar(8) not null, 
    complemento varchar(150) not null,
    rua varchar(150) not null,
    cidade varchar(50) not null,
    idCliente int,
    primary key(idObra)    
);*/

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