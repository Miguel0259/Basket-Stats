CREATE DATABASE BASKET_STATS;
USE BASKET_STATS;

CREATE TABLE treinadores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    idade VARCHAR(10),
    telefone VARCHAR(20),
    email VARCHAR(100),
    senha VARCHAR(50),
    equipe VARCHAR(100)
);

CREATE TABLE atletas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    idade VARCHAR(10),
    peso DOUBLE,
    altura DOUBLE,
    pontos DOUBLE,
    rebotes DOUBLE,
    assistencias DOUBLE,
    telefone VARCHAR(20),
    posicao VARCHAR(50),
    time VARCHAR(100),
    camp_atual VARCHAR(100)
);


ALTER TABLE atletas
ADD COLUMN email VARCHAR(100),
ADD COLUMN senha VARCHAR(100);
select*from atletas;

