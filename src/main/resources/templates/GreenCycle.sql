use master if exists(
select * from Sys.databases where name = 'bd_GreenCycle')

DROP DATABASE bd_GreenCycle

CREATE DATABASE bd_GreenCycle
go
USE bd_GreenCycle	


CREATE TABLE Usuario(
id int identity not null,
nome varchar(100) not null,
email varchar(100) not null,
senha varchar(100) not null,
RG varchar(11) constraint teste_so_num check(RG  not like '%[^0-9]% '),
sexo varchar(11) constraint teste_so_sexo check(sexo  not like '%[^masculino]% ''%[^feminino]% '),
data_nasc date not null,

     PRIMARY KEY ( id)
 
)


	CREATE TABLE Cliente 
( 
	id		 INT		  IDENTITY,
	CPF      CHAR(11) NOT NULL,
	nome     VARCHAR(40) NOT NULL, 
	telefone char(40)  NOT NULL,
	email    varchar(100) NOT  NULL,
	dat_nasc date not null,
	senha    varchar(100) not null,
	
	PRIMARY KEY (id),
	FOREIGN KEY (id) REFERENCES usuario(id)
)

CREATE TABLE Pedido
(					  
	id		        INT		  IDENTITY,
	data_entrega	DATETIME NOT NULL,
	qualidade	    CHAR(11)	  NOT NULL,
	status_produto  int    not null,
PRIMARY KEY (id),
FOREIGN KEY (id) REFERENCES Cliente(id),
FOREIGN KEY (id) REFERENCES usuario(id)

)
	
 CREATE TABLE Produto (
 id          INT IDENTITY,
PRECO        DECIMAL(5,2) NOT NULL, 
NOME         VARCHAR(100) NOT NULL,
GARANTIA     VARCHAR(20) NOT NULL,
MARCA        VARCHAR(50) NOT NULL,
 
PRIMARY KEY(id),
FOREIGN KEY (id) REFERENCES pedido(id)
)
CREATE TABLE item_pedido
(					  
	id	                    INT	  IDENTITY,
    confer_item_pedido      VARCHAR (100) NOT NULL,
	quantidade              CHAR(11)	  NOT NULL,
	primary key(id),
FOREIGN KEY (id) REFERENCES produto(id)
)


CREATE TABLE Pagto_Pedido(
id int identity,
primary key(id),
FOREIGN KEY (id) REFERENCES item_pedido(id)

)

CREATE TABLE Forma_Pagamento(
id         int identity,
debito     decimal(6,2) not null,
credito    decimal(6,2) not null,
pix        decimal(6,2) not null,
boleto     decimal(6,2) not null

primary key(id),
FOREIGN KEY (id) REFERENCES pedido(id),
FOREIGN KEY (id) REFERENCES item_pedido(id),
FOREIGN KEY (id) REFERENCES produto(id),
FOREIGN KEY (id) REFERENCES pagto_Pedido(id)
)

CREATE TABLE local_de_entrega(
id           int identity,
logradouro   varchar(100) not null,
numero_resid varchar(10) not null,
complemento  varchar(100) null,
cep          char(8)  null,
bairro       varchar(100) not null,
cidade       varchar(100) not null,
uf           char(2) not null,

primary key(id),
FOREIGN KEY (id) REFERENCES Forma_Pagamento(id)
)



INSERT Cliente(nome, telefone, email, dat_nasc)
VALUES ('Beatriz Santos', '11987219090', 'BeatrizSantos@gmail.com', 'barueri', '05/06/1667')
SELECT * FROM Cliente
Drop table Cliente


INSERT pedido (data_entrega, qualidade)
VALUES ('07/09/2023', 'boa')
SELECT * FROM pedido
--Drop table pedido

INSERT item_pedido (confer_item_pedido, quantidade)
VALUES ('ok', '1')
SELECT * FROM item_pedido
--Drop table item_pedido


INSERT Produto (preco, nome, garantia, marca)
VALUES ('5,20', 'ronaldo', '1 ano', 'nike')
SELECT * FROM item_pedido
--Drop table item_pedido

INSERT Usuario(nome, senha, RG, sexo,data_nasc)
VALUES ('giovanio', 'giovanio@gmail.com', 'giovanio2009', '25.778.451.00', 'masculino','10/11/1987')
SELECT * FROM Usuario
--Drop table Usuario
