--CREATE TABLE

create table COMPRADOR (
    id_comprador serial primary key,
    primeiro_nome varchar(100) not null,
    segundo_nome varchar(100) not null,
    email varchar(150) unique not null,
    cpf varchar(14) unique not null,
    senha varchar(40) not null,
    tipo_conta varchar(1) default('C'),
    telefone varchar(20),
    nacionalidade varchar(50),
    data_nascimento date
);

create table ARTISTA (
    id_artista serial primary key,
    primeiro_nome varchar(100) not null,
    segundo_nome varchar(100) not null,
    email varchar(150) unique not null,
    cpf varchar(14) unique not null,
    senha varchar(40) not null,
    tipo_conta varchar(1) default('A'),
    telefone varchar(20),
    nacionalidade varchar(50),
    data_nascimento date
);

create table ARTE (
    id_arte serial primary key,
    nome varchar(100) not null,
    copyright varchar(100) not null,
    valor decimal not null,
    adicional varchar(250),
    imagem text not null,
    id_comprador int,
    id_artista int,
    foreign key (id_comprador) references COMPRADOR (id_comprador) on delete cascade,
    foreign key (id_artista) references ARTISTA (id_artista) on delete cascade
);
--ALTER TABLE

alter table ARTISTA
    add column data_cadastro DATE

alter table COMPRADOR
    add column data_cadastro DATE

alter table ARTE
    add column data_cadastro DATE


--INSERT INTO

insert into COMPRADOR (primeiro_nome, segundo_nome, email, cpf, senha, tipo_conta)
	values (?,?,?,?,?,?);

insert into ARTE (
    nome,
    copyright,
    valor,
    adicional,
    imagem,
    id_artista,
    data_cadastro
) values (
    'arte1',
    'Usuarioedt#Direitos',
    29.90, 
    'Primeira arte da minha carreira',
    'sdfmhgsdjhfgsdlih',
    1,
    CURRENT_DATE
);

