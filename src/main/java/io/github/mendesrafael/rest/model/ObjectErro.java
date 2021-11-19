package io.github.mendesrafael.rest.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ObjectErro {

	@Getter
	@Setter
	private List<String> errors = new ArrayList<>();
	
	public ObjectErro(List<String> errors) {
		this.errors = errors;
	}
	
	public ObjectErro (String mensagemErrors) {
		this.errors.add(mensagemErrors);
	}
	
}
