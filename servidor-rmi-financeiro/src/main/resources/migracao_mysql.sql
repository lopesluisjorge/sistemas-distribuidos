DROP DATABASE IF EXISTS financeiro;

CREATE DATABASE financeiro;

USE financeiro;

CREATE TABLE aluno (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  matricula INT UNSIGNED UNIQUE NOT NULL,
  curso VARCHAR (255),
  PRIMARY KEY (id));

CREATE TABLE mensalidade (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  aluno_id INT UNSIGNED NOT NULL, 
  valor DOUBLE UNSIGNED NOT NULL,
  data_vencimento DATE NOT NULL,
  data_pagamento DATE,
  PRIMARY KEY (id),
  FOREIGN KEY (aluno_id) REFERENCES aluno(id));

INSERT INTO aluno
  (nome, matricula, curso)
VALUES
  ('Ana', 1, 'SI'),
  ('Beatriz', 2, 'MECANICA'),
  ('Marta', 3, 'FISICA'),
  ('Julia', 4, 'SI'),
  ('Joao', 5, 'SI'),
  ('Mario', 6, 'MECANICA');

INSERT INTO mensalidade
  (aluno_id, valor, data_vencimento, data_pagamento)
VALUES
  (1, 100, '2019-02-02', '2019-02-02'),
  (2, 100, '2019-02-02', '2019-02-20'),
  (3, 100, '2019-02-02', '2019-02-02'),
  (4, 100, '2019-02-10', '2019-02-10'),
  (5, 100, '2019-02-20', '2019-03-20'),
  (6, 100, '2019-02-10', NULL),         -- Para debito
  (1, 100, '2019-03-01', NULL),         -- Para debito
  (2, 100, '2019-03-01', '2019-02-02'),
  (3, 100, '2019-03-01', NULL),         -- Para debito
  (4, 100, '2019-03-01', '2019-02-02'),
  (5, 100, '2019-03-20', '2019-03-30'),
  (6, 100, '2019-03-10', NULL),         -- Para debito
  (1, 100, '2019-04-02', NULL),
  (2, 100, '2019-04-02', NULL),
  (3, 100, '2019-04-01', NULL),
  (4, 100, '2019-04-01', '2019-04-02'),
  (5, 100, '2019-04-20', '2019-04-27'),
  (6, 100, '2019-04-10', NULL);
