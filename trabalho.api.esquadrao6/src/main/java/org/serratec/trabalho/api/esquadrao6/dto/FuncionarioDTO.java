package org.serratec.trabalho.api.esquadrao6.dto;

public class FuncionarioDTO {
	
	private Integer FuncionarioId;
	private String funcionarioNome;
	private String funcionarioCpf;
	
	public FuncionarioDTO() {}

	public FuncionarioDTO(Integer funcionarioId, String funcionarioNome, String funcionarioCpf) {
		super();
		FuncionarioId = funcionarioId;
		this.funcionarioNome = funcionarioNome;
		this.funcionarioCpf = funcionarioCpf;
	}

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
