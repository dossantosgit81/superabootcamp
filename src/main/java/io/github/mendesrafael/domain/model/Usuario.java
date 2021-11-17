package io.github.mendesrafael.domain.model;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;

@Entity
@Table(name="USUARIOS")
@ApplicationScoped
public class Usuario extends PanacheEntityBase{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usu_id")
	private Long id;
	
	@Column(name="usu_login")
	@Getter
	private String login;
	
	@Column(name="usu_pwd")
	@Getter
	private String password;
	
	@Column(name="usu_dtcadastro")
	private LocalDateTime dataCadastro;
	
	@Column(name="usu_dtexpiracao")
	private LocalDateTime dataExpiracao;
	
	@Column(name="usu_situacao")
	public String situacao;
	
	@OneToOne
	@JoinColumn(name="alun_id")
	private PessoaFisica pessoaFisica;

	public Optional<Usuario> findBylogin(String login){
		return find("login", login).firstResultOptional();
	}
	
	
}
