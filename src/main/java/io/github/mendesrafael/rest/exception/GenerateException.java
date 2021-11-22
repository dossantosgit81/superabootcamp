package io.github.mendesrafael.rest.exception;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.twilio.exception.ApiException;

import io.github.mendesrafael.exceptions.CodigoNotValidException;
import io.github.mendesrafael.exceptions.NotFindEntityException;
import io.github.mendesrafael.rest.model.ObjectErro;

@Provider
public class GenerateException implements ExceptionMapper<Exception> {

	private final static int NOT_AUTHORIZED= 401;
	
	@Override
	@Produces(MediaType.APPLICATION_JSON)
	public Response toResponse(Exception e) {
		if(e instanceof NotFindEntityException) {
			ObjectErro objectErro = new ObjectErro(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(objectErro).build();
		}
		
		if(e instanceof NotAuthorizedException) {
			ObjectErro objectErro = new ObjectErro(e.getMessage());
			return Response.status(NOT_AUTHORIZED).entity(objectErro).build();
		}
		
		if(e instanceof CodigoNotValidException) {
			ObjectErro objectErro = new ObjectErro(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(objectErro).build();
		}
		
		if(e instanceof NotFindEntityException) {
			ObjectErro objectErro = new ObjectErro(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(objectErro).build();
		}
		
		if(e instanceof ApiException) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ObjectErro("Verifique as credenciais de envio de sms")).build();
		}
	
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ObjectErro("Erro inesperado, me perdoe")).build();
	}
	
}
