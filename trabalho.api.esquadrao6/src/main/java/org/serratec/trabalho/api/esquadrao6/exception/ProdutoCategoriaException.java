package org.serratec.trabalho.api.esquadrao6.exception;

public class ProdutoCategoriaException extends Exception {
	private static final long serialVersionUID = 1L;

	public ProdutoCategoriaException() {
		super();
	}

	public ProdutoCategoriaException(String message) {
		super(message);
	}

	public ProdutoCategoriaException(String message, Exception cause) {
		super(message, cause);
	}

	public ProdutoCategoriaException(Exception e) {
		super(e);
	}

}
