package io.github.mendesrafael.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.github.mendesrafael.domain.model.Rematricula;
import io.github.mendesrafael.domain.model.dto.RematriculaDTO;

@Path("/rematriculas")
public class RematriculaResources {
	
	@Inject Rematricula rematriculaEntity;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RematriculaDTO> listAll(){
		
		return RematriculaDTO.transformTypeList(Rematricula.findAll().list());
	}

}
