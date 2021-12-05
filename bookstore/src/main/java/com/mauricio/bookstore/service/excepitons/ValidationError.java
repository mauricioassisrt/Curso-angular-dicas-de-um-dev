package com.mauricio.bookstore.service.excepitons;

import java.util.ArrayList;
import java.util.List;

import com.mauricio.bookstore.resources.execptions.StandardError;

public class ValidationError extends StandardError{

	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timestamp, Integer status, String message) {
		super(timestamp, status, message);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		 this.errors.add(new FieldMessage(fieldName, message));
	}

	
}
