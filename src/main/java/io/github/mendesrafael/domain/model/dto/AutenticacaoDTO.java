package io.github.mendesrafael.domain.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;

@Data
public class AutenticacaoDTO {
	
	@NotBlank(message ="Cpf não pode ser vazio")
	@Size(min=11 , max=11, message="O campo precisa ter 11 caracteres")
	@Getter
	private String login;
	
	@NotBlank(message="Senha não pode ser vazia")
	@Size(min=6, max=20, message="O campo precisa estar entre 6 e 20 caracteres")
	@Getter
	private String password;

}
