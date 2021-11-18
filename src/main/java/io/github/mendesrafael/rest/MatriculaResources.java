package io.github.mendesrafael.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.github.mendesrafael.domain.model.PessoaFisica;
import io.github.mendesrafael.domain.model.Rematricula;
import io.github.mendesrafael.domain.model.dto.RematriculaDTO;

//Sei que ficou errado , mas já é 18:53 do dia 18 e eu nem comecei o front ainda
@Path("/usuarios")
public class MatriculaResources {
	
	@Inject Rematricula rematriculaEntity;
	
	@Inject JsonWebToken jwt;
	
	@GET
	//@Authenticated
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{idUsuario}/matriculas")
	public List<RematriculaDTO> listAll(@PathParam("idUsuario") Long idUsuario){
		PessoaFisica pf = PessoaFisica.findById(idUsuario);
		 
		return RematriculaDTO.transformTypeList(pf.getRematriculas());
			
	}

}
