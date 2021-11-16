package io.github.mendesrafael.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="PESSOA_FISICA")
public class PessoaFisica extends PanacheEntityBase{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ALUN_ID")
	public Long id;
	
	@Column(name="ALUN_DT_NASCIMENTO")
	public LocalDateTime dataNascimento;
	
	@Column(name ="ALUN_NOME")
	public String nome;
	
	@Column(name="ALUN_EMAIL")
	public String email;
	
	@Column(name="ALUN_CPF")
	public String cpf;
	
	@Column(name="ALUN_TELEFONE1")
	public String telefone1;
	
	@Column(name="ALUN_TELEFONE2")
	public String telefone2;
	
}
