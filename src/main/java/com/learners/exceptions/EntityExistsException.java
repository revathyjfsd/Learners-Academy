package com.learners.exceptions;

public class EntityExistsException extends Exception{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String exceptionMessage;
	public EntityExistsException(String exceptionMessage) {
		super();
		this.exceptionMessage = exceptionMessage;
	}

	public String toString() {
	   	 return this.exceptionMessage;
	    }


}
