package io.github.mendesrafael.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;

@Entity
@Table(name="PESSOA_FISICA")
@ApplicationScoped
public class PessoaFisica extends PanacheEntityBase{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ALUN_ID")
	@Getter
	private Long id;
	
	@Column(name="ALUN_DT_NASCIMENTO")
	private LocalDateTime dataNascimento;
	
	@Column(name ="ALUN_NOME")
	private String nome;
	
	@Column(name="ALUN_EMAIL")
	@Getter
	private String email;
	
	@Column(name="ALUN_CPF")
	private String cpf;
	
	@Column(name="ALUN_TELEFONE1")
	@Getter
	private String telefone1;
	
	@Column(name="ALUN_TELEFONE2")
	@Getter
	private String telefone2;
	
	@OneToMany(mappedBy="pessoaFisica")
	@Getter
	private List<Rematricula> rematriculas;

	
}
