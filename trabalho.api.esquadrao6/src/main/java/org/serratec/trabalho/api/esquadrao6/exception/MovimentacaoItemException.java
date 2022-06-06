package org.serratec.trabalho.api.esquadrao6.exception;

public class MovimentacaoItemException extends Exception {
	private static final long serialVersionUID = 1L;

	public MovimentacaoItemException() {
		super();
	}

	public MovimentacaoItemException(String message) {
		super(message);
	}

	public MovimentacaoItemException(String message, Exception cause) {
		super(message, cause);
	}

	public MovimentacaoItemException(Exception e) {
		super(e);
	}

}
