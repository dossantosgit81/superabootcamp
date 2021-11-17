package io.github.mendesrafael.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;

import io.github.mendesrafael.domain.model.Usuario;
import io.github.mendesrafael.rest.dto.AutenticacaoDTO;
import io.github.mendesrafael.rest.dto.AutenticacaoResponseDTO;
import io.github.mendesrafael.util.GerarToken;

@ApplicationScoped
public class AutenticacaoService {
	
	@Inject GerarToken gerarToken;
	
	@Inject Usuario usuarioEntity;
	
	public AutenticacaoResponseDTO efetuarLogin(AutenticacaoDTO autenticacaoDTO) {
		
		var result = usuarioEntity.findBylogin(autenticacaoDTO.getLogin());
		
		if(result.isEmpty()) {
			throw new NotAuthorizedException("Login ou senha invalidos");
		}
		
		var token = gerarToken.GeradorDeToken(result.get());
		
		var responseDTO = 
				AutenticacaoResponseDTO
				.builder()
					.login(AutenticacaoResponseDTO.loginQuebrado(autenticacaoDTO.getLogin()))
					.token(token).build();
		
		return responseDTO;
		
		
	}

}
