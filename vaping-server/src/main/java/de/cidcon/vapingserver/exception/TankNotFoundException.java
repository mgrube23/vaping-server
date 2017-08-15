package de.cidcon.vapingserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TankNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TankNotFoundException(String name) {
		super("could not find tank '" + name + "'.");
	}
	
	public TankNotFoundException(String brandName, String name) {
		super("could not find tank '" + name + "' for brand '" + brandName + "'.");
	}

}
