package io.github.mendesrafael.domain.model;

import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;
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
@ApplicationScoped
public class Rematricula extends PanacheEntityBase{
	
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
