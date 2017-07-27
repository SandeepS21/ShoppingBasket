package com.rbc.app.shopping.exception;

/**
 * In case of in-valide Item condition this class is used as exception object
 *
 */
public class InvalidItemException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidItemException(String cause) {
		super(cause);
	}
}
