-- Drop table

-- DROP TABLE Sige.dbo.PESSOA_FISICA;

CREATE TABLE PESSOA_FISICA (
	ALUN_ID int IDENTITY(1,1) NOT NULL, 
	ALUN_DT_NASCIMENTO datetime NULL,
	ALUN_NOME varchar(150) COLLATE Latin1_General_CI_AS NOT NULL,
	ALUN_EMAIL varchar(200) COLLATE Latin1_General_CI_AS NOT NULL,
	ALUN_CPF char(11) COLLATE Latin1_General_CI_AS NOT NULL,
	ALUN_TELEFONE1 varchar(20) COLLATE Latin1_General_CI_AS NULL,
	ALUN_TELEFONE2 varchar(20) COLLATE Latin1_General_CI_AS NULL,
	CONSTRAINT PK3 PRIMARY KEY (ALUN_ID)
);


CREATE TABLE USUARIOS (
	usu_id int IDENTITY(1,1) NOT NULL,
	usu_login varchar(50) COLLATE Latin1_General_CI_AS NOT NULL,
	usu_pwd varchar(255) COLLATE Latin1_General_CI_AS NOT NULL,
	usu_dtcadastro datetime NOT NULL,
	usu_dtexpiracao datetime NULL,
	usu_situacao varchar(255) COLLATE Latin1_General_CI_AS NOT NULL,
	alun_id int NOT NULL,
	CONSTRAINT PK_CLI_USUARIOS PRIMARY KEY (usu_id),
	CONSTRAINT UNK_CLI_USUARIOS UNIQUE (usu_login),
	CONSTRAINT FK_IDPESSOA_USU FOREIGN KEY (alun_id) REFERENCES PESSOA_FISICA(alun_id)
);

CREATE UNIQUE NONCLUSTERED INDEX UNK_USUARIOS ON USUARIOS (usu_login);

CREATE TABLE REMATRICULA (
	REMA_ID int IDENTITY(1,1) NOT NULL,
	ALUN_ID int NOT NULL,
	REMA_DT_INCLUSAO date NOT NULL,
	COD_CUROS nvarchar(11) COLLATE Latin1_General_CI_AS NULL,
	NOME_CURSO nvarchar(11) COLLATE Latin1_General_CI_AS NULL,
	REMA_STATUS nvarchar(11) COLLATE Latin1_General_CI_AS NULL,
	CONSTRAINT PK_SIG_REMATRICULA PRIMARY KEY (REMA_ID),
	CONSTRAINT FK_IDPESSOA_REMA FOREIGN KEY (alun_id) REFERENCES PESSOA_FISICA(alun_id)
);





