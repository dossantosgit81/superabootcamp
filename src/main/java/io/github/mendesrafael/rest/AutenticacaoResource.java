package io.github.mendesrafael.rest;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.github.mendesrafael.domain.model.dto.AutenticacaoDTO;
import io.github.mendesrafael.domain.model.dto.AutenticacaoResponseDTO;
import io.github.mendesrafael.service.AutenticacaoService;

@Path("/auth")
public class AutenticacaoResource {
	
	@Inject AutenticacaoService autenticacaoService;
	
	@Inject JsonWebToken jwt;
	
	@PermitAll
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public AutenticacaoResponseDTO autenticacao(@Valid AutenticacaoDTO autenticacaoDTO) {
		return autenticacaoService.efetuarLogin(autenticacaoDTO);
	}

}
