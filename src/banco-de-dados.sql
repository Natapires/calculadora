-- Criar o banco de dados
CREATE DATABASE IF NOT EXISTS supermercado_db;

-- Usar o banco de dados
USE supermercado_db;

-- Tabela de produtos
CREATE TABLE produtos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  preco DECIMAL(10, 2) NOT NULL
);

-- Tabela de configuração do supermercado
CREATE TABLE configuracao_supermercado (
  nome VARCHAR(100) NOT NULL,
  endereco VARCHAR(100) NOT NULL
);

-- Inserir dados de configuração padrão
INSERT INTO configuracao_supermercado (nome, endereco) VALUES ('Meu Supermercado', 'Rua Principal 123');
