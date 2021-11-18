package io.github.mendesrafael.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.github.mendesrafael.exceptions.NotFindEntityException;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.smallrye.common.annotation.Blocking;

@ApplicationScoped
public class EmailService {
	
	private final static String VALIDAR_EMAIL = "Validar email";
	
	@Inject Mailer mailer;
	
	@Blocking
	public String enviarEmail(Long idPessoa) {
		TelefoneService tfs = new TelefoneService();
		
		var userEncontrado = tfs.buscarPessoa(idPessoa);
		if(userEncontrado == null) {
			throw new NotFindEntityException("Usuario não encontrado");
		}
		
		var subject = Mail.withText(
				userEncontrado.getEmail(),
				VALIDAR_EMAIL, 
				TelefoneService.gerarCodigo().toString());
		
		 mailer.send(
				 subject
				);
		 
		 return subject.getText();
	}

}
