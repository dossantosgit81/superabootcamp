package io.github.mendesrafael.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="REMATRICULA")
public class Rematricula extends PanacheEntityBase{
	
	/*
	 * CREATE TABLE REMATRICULA (
	REMA_ID int IDENTITY(1,1) NOT NULL,
	ALUN_ID int NOT NULL,
	REMA_DT_INCLUSAO date NOT NULL,
	COD_CUROS nvarchar(11) COLLATE Latin1_General_CI_AS NULL,
	NOME_CURSO nvarchar(11) COLLATE Latin1_General_CI_AS NULL,
	REMA_STATUS nvarchar(11) COLLATE Latin1_General_CI_AS NULL,
	CONSTRAINT PK_SIG_REMATRICULA PRIMARY KEY (REMA_ID),
	CONSTRAINT FK_IDPESSOA_REMA FOREIGN KEY (alun_id) REFERENCES PESSOA_FISICA(alun_id)
);
	 * */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REMA_ID")
	public Long id;
	
	@Column(name="REMA_DT_INCLUSAO")
	public LocalDate dataInclusao;
	
	@Column(name="COD_CUROS")
	public Long codigoCurso;
	
	@Column(name="NOME_CURSO")
	public String nomeCurso;
	
	@Column(name="REMA_STATUS")
	public String status;
	
	@ManyToOne
	@JoinColumn(name="ALUN_ID")
	public PessoaFisica pessoaFisica;
	
}
