package org.serratec.trabalho.api.esquadrao6.dto;

import java.io.Serializable;

public class FuncionarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	// Atributos específicos da classe
	private Integer FuncionarioId;
	private String funcionarioNome;
	private String funcionarioCpf;

	// Construtor Vazio
	public FuncionarioDTO() {
	}

	// Getters e Setters
	public Integer getFuncionarioId() {
		return FuncionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		FuncionarioId = funcionarioId;
	}

	public String getFuncionarioNome() {
		return funcionarioNome;
	}

	public void setFuncionarioNome(String funcionarioNome) {
		this.funcionarioNome = funcionarioNome;
	}

	public String getFuncionarioCpf() {
		return funcionarioCpf;
	}

	public void setFuncionarioCpf(String funcionarioCpf) {
		this.funcionarioCpf = funcionarioCpf;
	}

}
