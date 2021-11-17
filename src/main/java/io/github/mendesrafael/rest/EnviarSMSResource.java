package io.github.mendesrafael.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.github.mendesrafael.domain.model.dto.EnviarSMSDTO;
import io.github.mendesrafael.service.EnviarSMSService;

@Path("/sms")
public class EnviarSMSResource {
	
	@Inject 
	@RestClient
	EnviarSMSService enviarSms;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public EnviarSMSDTO enviarEmail(EnviarSMSDTO obj) {
		return enviarSms.enviarsms(obj);
	}

}
