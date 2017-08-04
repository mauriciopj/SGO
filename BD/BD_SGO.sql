-- drop database sgo;

create database sgo;

use sgo;

-- select * from clientes;

create table clientes(
	idCli int auto_increment not null primary key,
	nome varchar(150) not null,
	cpf varchar(11),
	cnpj varchar(14),
    fone varchar(11) not null,
    email varchar(150) not null,
    bairro varchar(150) not null,
    numero varchar(8) not null, 
    rua varchar(150) not null
); 

insert into clientes() 
values('1','Maurício','11111111111',null,'11111111111','jose@hgfg','dsadas','25','fdsfdsa');

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
    qtd int,
	fornecedor int,
	foreign key(fornecedor) references fornecedores(idForn)
);

create table itemPedido(
	id int auto_increment not null primary key,
    material int,
    quantidade int,
    pedido int,
    foreign key(material) references materiais(idMate),   
    foreign key(pedido) references pedidos(id)
);

create table listafuncionarios (
	idLF int auto_increment not null primary key,
    funcionario int,
    trabalho int,
    foreign key(funcionario) references funcionarios(idFunc), 
    foreign key(trabalho) references trabalhos(idTrab)
);

-- insert into funcionarios(idFunc,cpf,nome,fone,cargo,email,bairro,numero,rua,salario) values (1,'11111111111','Januária','38991586654',1,'gfdg','gfdg','dfg','fdsfsd',1222);