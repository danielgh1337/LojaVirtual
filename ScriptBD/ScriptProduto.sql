CREATE TABLE produto (
	pro_id 	  SERIAL,
	pro_nome  VARCHAR(60) NOT NULL,
	pro_preco FLOAT NOT NULL,
	CONSTRAINT pkProduto PRIMARY KEY(pro_id));

CREATE TABLE pessoa (
    pes_id			SERIAL,
    pes_nome		VARCHAR(60),
    pes_cpf			CHAR(14),
    pes_rg			VARCHAR(20),
    pes_data_nasc	DATE,
    pes_rua			VARCHAR(60),
    pes_bairro		VARCHAR(30),
    pes_cidade		VARCHAR(30),
    pes_uf			CHAR(2),
    pes_cep			INTEGER,
    pes_email		VARCHAR(40),
    pes_senha		VARCHAR(32),
    CONSTRAINT pkPessoa PRIMARY KEY (pes_id));

CREATE TABLE fone (
    fon_id	SERIAL,
    pes_id	INTEGER,
    fon_numero	VARCHAR(20),
    fon_descricao	VARCHAR(30),
 	CONSTRAINT pkFone PRIMARY KEY (fon_id),
	CONSTRAINT fkPessoaFone FOREIGN KEY (pes_id) REFERENCES pessoa (pes_id));