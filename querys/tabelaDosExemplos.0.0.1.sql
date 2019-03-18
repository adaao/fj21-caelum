-- use fj21;

CREATE TABLE contatos (
  id SERIAL,
  nome VARCHAR(255),
  email VARCHAR(255),
  endereco VARCHAR(255),
  dataNascimento DATE,
  PRIMARY KEY (id)
);
