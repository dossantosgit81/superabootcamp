package io.github.mendesrafael.util;

import java.time.Duration;
import java.time.Instant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.JsonWebToken;

import io.github.mendesrafael.domain.model.Usuario;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class GerarToken {
	
	@ConfigProperty(name="mp.jwt.verify.issuer")
	String emissorDoToken;
	
	@Inject JsonWebToken jwt;
	
	public String GeradorDeToken(Usuario usuario) {
		
		 String token =
		           Jwt.issuer(emissorDoToken) 
		           	.expiresAt(Instant.now().plus(Duration.ofHours(2)))
		             .upn(usuario.getLogin()) 
		           .sign();
		
		 return token;
	}
	

}
