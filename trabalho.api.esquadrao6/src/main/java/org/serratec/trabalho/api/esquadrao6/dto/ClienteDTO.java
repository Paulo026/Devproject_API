package org.serratec.trabalho.api.esquadrao6.dto;

import java.time.LocalDate;

public class ClienteDTO {
	
	private Integer clienteId;
	private String clienteNome;
	private String clienteUsuario;
	private String clienteSenha;
	private String clienteEmail;
	private String clienteCpf;
	private LocalDate clienteDataNascimento;
	private String clienteEnderecoCompleto;
	private String clienteTelefone;
	private String clienteCep;
	
	public ClienteDTO() {}

	public ClienteDTO(Integer clienteId, String clienteNome, String clienteUsuario, String clienteSenha,
			String clienteEmail, String clienteCpf, LocalDate clienteDataNascimento, String clienteEnderecoCompleto,
			String clienteTelefone) {
		super();
		this.clienteId = clienteId;
		this.clienteNome = clienteNome;
		this.clienteUsuario = clienteUsuario;
		this.clienteSenha = clienteSenha;
		this.clienteEmail = clienteEmail;
		this.clienteCpf = clienteCpf;
		this.clienteDataNascimento = clienteDataNascimento;
		this.clienteEnderecoCompleto = clienteEnderecoCompleto;
		this.clienteTelefone = clienteTelefone;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	public String getClienteUsuario() {
		return clienteUsuario;
	}

	public void setClienteUsuario(String clienteUsuario) {
		this.clienteUsuario = clienteUsuario;
	}

	public String getClienteSenha() {
		return clienteSenha;
	}

	public void setClienteSenha(String clienteSenha) {
		this.clienteSenha = clienteSenha;
	}

	public String getClienteEmail() {
		return clienteEmail;
	}

	public void setClienteEmail(String clienteEmail) {
		this.clienteEmail = clienteEmail;
	}

	public String getClienteCpf() {
		return clienteCpf;
	}

	public void setClienteCpf(String clienteCpf) {
		this.clienteCpf = clienteCpf;
	}

	public LocalDate getClienteDataNascimento() {
		return clienteDataNascimento;
	}

	public void setClienteDataNascimento(LocalDate clienteDataNascimento) {
		this.clienteDataNascimento = clienteDataNascimento;
	}

	public String getClienteEnderecoCompleto() {
		return clienteEnderecoCompleto;
	}

	public void setClienteEnderecoCompleto(String clienteEnderecoCompleto) {
		this.clienteEnderecoCompleto = clienteEnderecoCompleto;
	}

	public String getClienteTelefone() {
		return clienteTelefone;
	}

	public void setClienteTelefone(String clienteTelefone) {
		this.clienteTelefone = clienteTelefone;
	}
	
	public String getClienteCep() {
		return clienteCep;
	}

	public void setClienteCep(String clienteCep) {
		this.clienteCep = clienteCep;
	}

}