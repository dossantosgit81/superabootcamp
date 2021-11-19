package io.github.mendesrafael.rest;

import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.github.mendesrafael.domain.model.dto.AutenticacaoDTO;
import io.github.mendesrafael.exceptions.NotFindEntityException;
import io.github.mendesrafael.rest.model.ObjectErro;
import io.github.mendesrafael.service.AutenticacaoService;

@Path("/auth")
public class AutenticacaoResource {
	
	@Inject AutenticacaoService autenticacaoService;
	
	@Inject Validator validator;
	
	@Inject JsonWebToken jwt;
	
	@PermitAll
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response autenticacao(@FormParam("login") final String login, @FormParam("password") final String password ) {
		AutenticacaoDTO autenticacaoDTO = new AutenticacaoDTO();  
		autenticacaoDTO.setLogin(login);
		autenticacaoDTO.setPassword(password);
		
		Set<ConstraintViolation<AutenticacaoDTO>> violations = validator.validate(autenticacaoDTO);
		
		    if (!violations.isEmpty()) {
		    	var errors = violations.stream().map(e -> new String(e.getMessage())).collect(Collectors.toList());

		        return Response.status(Status.FORBIDDEN).entity(new ObjectErro(errors)).build();
		    } 
		    
		    var result = autenticacaoService.efetuarLogin(autenticacaoDTO);
		    
		    return Response.status(Status.OK).entity(result).build();
		
		
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void teste() {
		throw new NotFindEntityException("Error");
	}
}
