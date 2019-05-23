package com.jean.curso.ws.service.exception;

import java.io.Serializable;

public class ObjectNotFoundException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = -1389352583174065483L;

	public ObjectNotFoundException(String message) {
		super(message);
	}
	
}
