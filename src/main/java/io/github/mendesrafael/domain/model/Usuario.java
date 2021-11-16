package io.github.mendesrafael.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="USUARIOS")
public class Usuario extends PanacheEntityBase{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usu_id")
	public Long id;
	
	@Column(name="usu_login")
	public String login;
	
	@Column(name="usu_pwd")
	public String password;
	
	@Column(name="usu_dtcadastro")
	public LocalDateTime dataCadastro;
	
	@Column(name="usu_dtexpiracao")
	public LocalDateTime dataExpiracao;
	
	@Column(name="usu_situacao")
	public String situacao;
	
	@OneToOne
	@JoinColumn(name="alun_id")
	public PessoaFisica pessoaFisica;
	
}
