INSERT INTO PESSOA_FISICA
(ALUN_DT_NASCIMENTO, ALUN_NOME, ALUN_EMAIL, ALUN_CPF, ALUN_TELEFONE1, ALUN_TELEFONE2)
VALUES('1998-01-02 00:00:00.000', 'Rafael', 'c1dc15f2cf-5c1fd8@inbox.mailtrap.io','12345678912' ,'89981061554', '89981061554');

INSERT INTO PESSOA_FISICA
(ALUN_DT_NASCIMENTO, ALUN_NOME, ALUN_EMAIL, ALUN_CPF, ALUN_TELEFONE1, ALUN_TELEFONE2)
VALUES('1998-01-02 00:00:00.000', 'Loris', 'lrs@gmail.com','98765432112' ,'98745635', '9876541235');

INSERT INTO PESSOA_FISICA
(ALUN_DT_NASCIMENTO, ALUN_NOME, ALUN_EMAIL, ALUN_CPF, ALUN_TELEFONE1, ALUN_TELEFONE2)
VALUES('1998-01-02 00:00:00.000', 'John', 'john@gmail.com','12345678914' ,'98745635', '9876541235');

INSERT INTO USUARIOS
(usu_login, usu_pwd, usu_dtcadastro, usu_dtexpiracao, usu_situacao, alun_id)
VALUES('12345678912', '$2a$04$ltca1QWorx9KhToeh6Pke.kdQERUWcaUQzWoSQLltkbhfMb6edh6u', '1998-01-02 00:00:00.000', '1998-02-02 00:00:00.000', 'Pendente', 1);

INSERT INTO USUARIOS
(usu_login, usu_pwd, usu_dtcadastro, usu_dtexpiracao, usu_situacao, alun_id)
VALUES('98765432112', '$2a$10$1/Xo4yEJMvdTSBC5XDWKKOlyL.dzkTyS4aAnMqKPmNUew4wRf.MHG', '1998-01-02 00:00:00.000', '1998-02-02 00:00:00.000', 'Pendente', 2);

INSERT INTO REMATRICULA
(ALUN_ID, REMA_DT_INCLUSAO, COD_CUROS, NOME_CURSO, REMA_STATUS)
VALUES(1, '1998-01-02 00:00:00', '1', 'Redes', 'Pendente');

INSERT INTO REMATRICULA
(ALUN_ID, REMA_DT_INCLUSAO, COD_CUROS, NOME_CURSO, REMA_STATUS)
VALUES(1, '1998-01-02 00:00:00', '2', 'Quarkus', 'Pendente');

INSERT INTO REMATRICULA
(ALUN_ID, REMA_DT_INCLUSAO, COD_CUROS, NOME_CURSO, REMA_STATUS)
VALUES(2, '1998-01-02 00:00:00', '3', 'React', 'Pendente');
