package com.rbc.app.shopping.exception;

/**
 * While lookup if no Item found in basket exception will be raised with this
 * object
 */
public class NoItemFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public NoItemFoundException(String cause) {
		super(cause);
	}
}
