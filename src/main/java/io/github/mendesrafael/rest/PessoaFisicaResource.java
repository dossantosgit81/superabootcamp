package io.github.mendesrafael.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.github.mendesrafael.domain.model.PessoaFisica;
import io.github.mendesrafael.domain.model.dto.PessoaCodigoDTO;
import io.github.mendesrafael.service.TelefoneService;

@Path("/pessoa-fisica")
public class PessoaFisicaResource {
	
	@Inject TelefoneService telService;
	 
	private String codigo;

	@GET
	@Path("/{idPessoa}/contato-one/{telefoneAValidar}/tfa")
	public Response enviarCodigoTelefone1(@PathParam("idPessoa") Long idPessoa, @PathParam("telefoneAValidar") Long telefoneAValidar){
		
		PessoaFisica pf ;
		
		if(telefoneAValidar == 1) {
			pf = telService.buscarPessoa(idPessoa);
			codigo = telService.disparar("+55"+pf.getTelefone1());
			
		} else {
			pf = telService.buscarPessoa(idPessoa);
			codigo = telService.disparar("+55"+pf.getTelefone2());
		}
		
		return Response.ok().build();
	}
	
	@PUT
	public Response enviarCodigoTelefone13(PessoaCodigoDTO pfdto){
		
		if(pfdto.getCodigo().equals(codigo) == true) {
			return Response.ok().build();
			
		}
			return Response.status(Status.BAD_REQUEST).build();
		
	}
	

}
