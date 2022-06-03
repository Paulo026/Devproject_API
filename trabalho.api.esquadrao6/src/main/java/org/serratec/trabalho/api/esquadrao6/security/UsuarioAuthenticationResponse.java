package org.serratec.trabalho.api.esquadrao6.security;

public class UsuarioAuthenticationResponse {

	private final String token;

	public String getToken() {
		return token;
	}

	public UsuarioAuthenticationResponse(String token) {
		super();
		this.token = token;
	}

}