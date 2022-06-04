package org.serratec.trabalho.api.esquadrao6.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

	private Integer idUsuario;
	private String Username;
	private String password;
	
	public UsuarioDTO() {
		
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
