package org.serratec.trabalho.api.esquadrao6.exception;

public class FuncionarioException extends Exception {

	private static final long serialVersionUID = 1L;

	public FuncionarioException() {
		super();
	}

	public FuncionarioException(String message) {
		super(message);
	}

	public FuncionarioException(String message, Exception cause) {
		super(message, cause);
	}

	public FuncionarioException(Exception e) {
		super(e);
	}

}
