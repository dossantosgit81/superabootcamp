package io.github.mendesrafael.exceptions;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

public class ValidationRequestException extends ConstraintViolationException{

	
	public ValidationRequestException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

}
