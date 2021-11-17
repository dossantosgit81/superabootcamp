package io.github.mendesrafael.util;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.Claims;

import io.github.mendesrafael.domain.model.Usuario;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class GerarToken {
	
	@ConfigProperty(name="mp.jwt.verify.issuer")
	String emissorDoToken;
	
	public String GeradorDeToken(Usuario usuario) {
		
		 String token =
		           Jwt.issuer(emissorDoToken) 
		           	.expiresAt(Instant.now().plus(Duration.ofHours(2)))
		             .upn(usuario.getLogin()) 
		             .groups(new HashSet<>(Arrays.asList("User"))) 
		             .claim(Claims.birthdate.name(), "2001-07-13") 
		           .sign();
		 
		       return token;
	}

}
