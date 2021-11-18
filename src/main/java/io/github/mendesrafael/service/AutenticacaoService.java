package io.github.mendesrafael.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;

import org.springframework.security.crypto.bcrypt.BCrypt;

import io.github.mendesrafael.domain.model.Usuario;
import io.github.mendesrafael.domain.model.dto.AutenticacaoDTO;
import io.github.mendesrafael.domain.model.dto.AutenticacaoResponseDTO;
import io.github.mendesrafael.util.GerarToken;

@ApplicationScoped
public class AutenticacaoService {
	
	@Inject GerarToken gerarToken;
	
	@Inject Usuario usuarioEntity;
	
	public AutenticacaoResponseDTO efetuarLogin(AutenticacaoDTO autenticacaoDTO) {
		
		var user = usuarioEntity.findBylogin(autenticacaoDTO.getLogin());
		
		if(user.isEmpty()) {
			throw new NotAuthorizedException("Login ou senha invalidos");
		}
		
		if(!BCrypt.checkpw(autenticacaoDTO.getPassword(), user.get().getPassword())) {
			throw new NotAuthorizedException("Login ou senha invalidos");
		}
		
		var token = gerarToken.GeradorDeToken(user.get());
		
		var responseDTO = 
				AutenticacaoResponseDTO
				.builder()
					.login(autenticacaoDTO.getLogin())
					.token(token).build();
		
		return responseDTO;
		
		
	}

}
