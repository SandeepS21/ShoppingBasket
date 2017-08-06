package com.rbc.app.shopping.exception;

/**
 * In case of in-valide basket condition this class is used as exception object
 *
 */
public class InvalidBasketException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidBasketException(String cause) {
		super(cause);
	}
}
