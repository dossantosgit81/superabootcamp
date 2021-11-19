package io.github.mendesrafael.rest.model;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ObjectErro {
	
	@Getter
	private List<String> errors;
	
	public ObjectErro(List<String> errors) {
		this.errors = errors;
	}
	
	public ObjectErro (String mensagemErrors) {
		this.errors = Arrays.asList(mensagemErrors);
	}

}
