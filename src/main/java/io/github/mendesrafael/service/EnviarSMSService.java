package io.github.mendesrafael.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.github.mendesrafael.domain.model.dto.EnviarSMSDTO;

@RegisterRestClient
public interface EnviarSMSService {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/send")
	EnviarSMSDTO enviarsms(EnviarSMSDTO obj);

}
