package io.github.mendesrafael.service;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import io.github.mendesrafael.domain.model.PessoaFisica;
import io.github.mendesrafael.domain.model.Usuario;
import io.github.mendesrafael.exceptions.NotFindEntityException;

@ApplicationScoped
public class TelefoneService {
	
	@Inject Usuario useEntiy;	
	
	@ConfigProperty(name="io.github.mafaelrendes.sms.account_sid")
	public String ACCOUNT_SID;
	
	@ConfigProperty(name="io.github.mafaelrendes.sms.token")
	public String AUTH_TOKEN;
	
	public String disparar(String numeroTelefone) {
 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber(numeroTelefone),  
                "MGde8b143a9764797721cd2ede221b4729", 
                gerarCodigo().toString())      
            .create(); 
 
        return message.getBody();
	    
	}
	
	public PessoaFisica buscarPessoa(Long id) {
		 
		PessoaFisica pf = PessoaFisica.findById(id);
		
		if(pf == null) {
			throw new NotFindEntityException("Usuario não encontrado");
		}
		
		return pf;
	    
	}
	
	private Integer gerarCodigo() {
		Random random = new Random();
		
		return random.nextInt(10000);
	}

}
