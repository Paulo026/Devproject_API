package org.serratec.trabalho.api.esquadrao6.exception;

public class PedidoItemException extends Exception{
    private static final long serialVersionUID = 1L;

    public PedidoItemException() {
        super();
    }

    public PedidoItemException(String message) {
        super(message);
    }


    public PedidoItemException(String message, Exception cause) {
        super(message, cause);
    }

    public PedidoItemException(Exception e) {
        super(e);
    }

}
