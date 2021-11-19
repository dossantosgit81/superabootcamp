package io.github.mendesrafael.rest.exception;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import io.github.mendesrafael.exceptions.CodigoNotValidException;
import io.github.mendesrafael.exceptions.NotFindEntityException;
import io.github.mendesrafael.rest.model.ObjectErro;

@Provider
public class GenerateException implements ExceptionMapper<Exception> {

	@Override
	@Produces(MediaType.APPLICATION_JSON)
	public Response toResponse(Exception e) {
		if(e instanceof NotFindEntityException) {
			ObjectErro objectErro = new ObjectErro(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(objectErro).build();
		}
		
		if(e instanceof NotAuthorizedException) {
			ObjectErro objectErro = new ObjectErro(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(objectErro).build();
		}
		
		if(e instanceof CodigoNotValidException) {
			ObjectErro objectErro = new ObjectErro(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(objectErro).build();
		}
		
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro inesperado").build();
	}

}
