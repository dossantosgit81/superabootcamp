package io.github.mendesrafael.rest;

import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.github.mendesrafael.domain.model.dto.AutenticacaoDTO;
import io.github.mendesrafael.rest.model.ObjectErro;
import io.github.mendesrafael.service.AutenticacaoService;

@Path("/auth")
public class AutenticacaoResource {
	
	@Inject AutenticacaoService autenticacaoService;
	
	@Inject Validator validator;
	
	@Inject JsonWebToken jwt;
	
	@PermitAll
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response autenticacao(AutenticacaoDTO autenticacaoDTO) {
		
		Set<ConstraintViolation<AutenticacaoDTO>> violations = validator.validate(autenticacaoDTO);
		
		    if (!violations.isEmpty()) {
		    	var errors = violations.stream().map(e -> new String(e.getMessage())).collect(Collectors.toList());

		        return Response.status(Status.BAD_REQUEST).entity(new ObjectErro(errors)).build();
		    } else {
		    	
		    	var result = autenticacaoService.efetuarLogin(autenticacaoDTO);
		    	
		    	return Response.status(Status.OK).entity(result).build();		
		    }
		    
	}

}
