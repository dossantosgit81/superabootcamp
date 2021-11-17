package io.github.mendesrafael.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.github.mendesrafael.domain.model.Rematricula;
import io.github.mendesrafael.domain.model.dto.RematriculaDTO;
import io.quarkus.security.Authenticated;

@Path("/rematriculas")
public class RematriculaResources {
	
	@Inject Rematricula rematriculaEntity;
	
	@Inject JsonWebToken jwt;
	
	@GET
	@Authenticated
	@Produces(MediaType.APPLICATION_JSON)
	@RequestScoped
	public List<RematriculaDTO> listAll(@Context SecurityContext ctx){
		if(jwt.getName() != null || !ctx.getUserPrincipal().getName().equals(jwt.getName())) {
			
			return RematriculaDTO.transformTypeList(Rematricula.findAll().list());
		}
		
    
		throw new BadRequestException("Token invalido");
	}
	
	

}
