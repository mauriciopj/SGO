-- drop database sgo;

create database sgo;

use sgo;

-- select * from itemPedido;

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

insert into clientes(nome,cpf,cnpj,fone,email,bairro,numero,rua) 
values('Maurício','11111111111',null,'11111111111','jose@hgfg','dsadas','25','fdsfdsa');

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

insert into funcionarios(cpf,nome,fone,cargo,email,bairro,numero,rua,salario) 
values ('11111111111','José Doido','11111111111',3,'jose@gmail.com','Alto','25','Dez',1222);
insert into funcionarios(cpf,nome,fone,cargo,email,bairro,numero,rua,salario) 
values ('11111111111','José Doido2','11111111111',3,'jose@gmail.com','Alto','25','Dez',1222);
insert into funcionarios(cpf,nome,fone,cargo,email,bairro,numero,rua,salario) 
values ('11111111111','José Doido4','11111111111',3,'jose@gmail.com','Alto','25','Dez',1222);

create table obrasEServicos(
	idObra int auto_increment not null primary key,
	descricao varchar(150) not null,
    bairro varchar(150) not null,
    numero varchar(8) not null, 
    complemento varchar(150),
    rua varchar(150) not null,
    cidade int not null,
    cliente int,
	foreign key(cliente) references clientes(idCli)
);

insert into obrasEServicos(descricao,bairro,numero,complemento,rua,cidade,cliente) 
values('Asfalto','Alto','5','---','Dois',2,1);	

create table fornecedores(
	idForn int auto_increment not null primary key,
	nome varchar(150) not null,
    fone varchar(11) not null,
    email varchar(150) not null,
    bairro varchar(150) not null,
    numero varchar(8) not null, 
    rua varchar(150) not null
);

insert into fornecedores(nome,fone,email,bairro,numero,rua) 
values('Construservs','11111111111','jose@hgfg','dsadas','25','fdsfdsa');

create table materiais(
	idMate int auto_increment not null primary key,
	nome varchar(50) not null,
    qtd int not null,
    valor varchar(50) not null,
    descricao varchar(150) not null
);

insert into materiais(nome, qtd, valor, descricao) 
values('Cimento',2000,'24','Saco');	

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

create table usuario(	
   id int auto_increment not null primary key,
   nome varchar(100) not null,
   login varchar(100) not null,
   senha varchar(100) not null 
);

insert into usuario(nome, login, senha) 
values('Administrador','admin','admin');	

create table pedidos(
	id int auto_increment not null primary key,
	data varchar(17) not null,
    qtdItens int,
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

create table trabalhos(
	id int auto_increment not null primary key,
	ultimaModificacao varchar(50),
	dataInicio varchar(50),
	dataTermino varchar(50),		
	andamento int not null,
	obraEServico int,
	foreign key(obraEServico) references obrasEServicos(idObra)
);

create table trabalhoFuncionario (
	id int auto_increment not null primary key,
    funcionario int,
    trabalho int,
    foreign key(funcionario) references funcionarios(idFunc), 
    foreign key(trabalho) references trabalhos(id)
);

-- Teste commit
