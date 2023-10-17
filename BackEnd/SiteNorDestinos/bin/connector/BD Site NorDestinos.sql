CREATE DATABASE nordestinos;

use NorDestinos;

CREATE TABLE Cliente(
idCliente INT AUTO_INCREMENT PRIMARY KEY,
nomeCliente VARCHAR(255) NOT NULL,
cpfcliente VARCHAR(11) UNIQUE NOT NULL,
endereçoCliente TEXT NOT NULL,
telefone VARCHAR(15),
loguin VARCHAR(255) NOT NULL,
senha VARCHAR(255) NOT NULL
);

CREATE TABLE Destinos(
idDestino INT AUTO_INCREMENT PRIMARY KEY,
nomeDestino varchar(255) NOT NULL,
valorDestino INT(20) NOT NULL,
idCliente INT NOT NULL,
FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente)
);


CREATE TABLE Compra (
idCompra INT AUTO_INCREMENT PRIMARY KEY,
nomeCompra varchar(255) NOT NULL,
valorCompra INT(20) NOT NULL,
idCliente INT NOT NULL,
FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente)
);


INSERT INTO Cliente(nomeCliente, cpfCliente, endereçoCliente, telefone, loguin, senha) 
  VALUES ('Grasielly','11111111111','Rua 1','5583911111111', 'Grasielly', '1111');
  
INSERT INTO Cliente(nomeCliente, cpfCliente, endereçoCliente, telefone, loguin, senha) 
	VALUES ('Marcus','22222222222','Rua 2','5583922222222', 'Marcus', '2222');
  
INSERT INTO Cliente(nomeCliente, cpfCliente, endereoCliente, telefone, loguin, senha) 
  VALUES ('Sofia','33333333333','Rua 3','5583933333333', 'Sofia', '3333');


INSERT INTO Destinos(nomeDestino, valorDestino) 
VALUES ('João Pessoa','2.000');  
INSERT INTO Destinos(nomeDestino, valorDestino) 
VALUES ('Pipa','2.000');  
INSERT INTO Destinos(nomeDestino, valorDestino) 
VALUES ('Porto de Galinhas','2.000'); 
INSERT INTO Destinos(nomeDestino, valorDestino) 
VALUES ('Jericoacoara','2.000'); 
INSERT INTO Destinos(nomeDestino, valorDestino) 
VALUES ('Lençoes Maranhences','2.000'); 
INSERT INTO Destinos(nomeDestino, valorDestino) 
VALUES ('Cachoeira do Urubu','2.000'); 
INSERT INTO Destinos(nomeDestino, valorDestino) 
VALUES ('Maragogi','2.000'); 
INSERT INTO Destinos(nomeDestino, valorDestino) 
VALUES ('Canions do São Francisco','2.000'); 
INSERT INTO Destinos(nomeDestino, valorDestino) 
VALUES ('Salvador','2.000');   
 

INSERT INTO Compra(nomeCompra, valorCompra) 
  VALUES ('João Pessoa','2.000');


SHOW TABLES;

select * from Cliente;

select * from Destinos;

select * from Compra;


  SELECT c.nomeCliente, d.nomeDestino, d.valorDestino 
  FROM Destino as d
  INNER JOIN Cliente as c
  ON d.idCliente = c.idCliente;







