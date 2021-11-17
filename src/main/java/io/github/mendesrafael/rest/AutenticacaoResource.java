package io.github.mendesrafael.rest;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import io.github.mendesrafael.domain.model.dto.AutenticacaoDTO;
import io.github.mendesrafael.domain.model.dto.AutenticacaoResponseDTO;
import io.github.mendesrafael.service.AutenticacaoService;

@Path("/auth")
public class AutenticacaoResource {
	
	@Inject AutenticacaoService autenticacaoService;
	
	@PermitAll
	@POST
	public AutenticacaoResponseDTO autenticacao(AutenticacaoDTO autenticacaoDTO) {
		return autenticacaoService.efetuarLogin(autenticacaoDTO);
	}

}
