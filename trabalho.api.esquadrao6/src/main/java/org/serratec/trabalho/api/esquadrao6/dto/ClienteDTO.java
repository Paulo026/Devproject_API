package org.serratec.trabalho.api.esquadrao6.dto;

import java.time.LocalDate;

public class ClienteDTO {
    //Atributos específicos da classe
    private Integer clienteId;
    private String clienteNome;
    private String clienteUsuario;
    private String clienteSenha;
    private String clienteEmail;
    private String clienteCpf;
    private LocalDate clienteDataNascimento;
    private String clienteTelefone;
    private String clienteEnderecoCompleto;
    private String clienteCep;

    //Atributos que se relacionam com outras classes
    private Integer movimentacaoID;

    //Construtor Vazio
	public ClienteDTO() {
	}


	//Getters e Setters
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

	public String getClienteTelefone() {
		return clienteTelefone;
	}

	public void setClienteTelefone(String clienteTelefone) {
		this.clienteTelefone = clienteTelefone;
	}

	public String getClienteEnderecoCompleto() {
		return clienteEnderecoCompleto;
	}

	public void setClienteEnderecoCompleto(String clienteEnderecoCompleto) {
		this.clienteEnderecoCompleto = clienteEnderecoCompleto;
	}

	public String getClienteCep() {
		return clienteCep;
	}

	public void setClienteCep(String clienteCep) {
		this.clienteCep = clienteCep;
	}

	public Integer getMovimentacaoID() {
		return movimentacaoID;
	}

	public void setMovimentacaoID(Integer movimentacaoID) {
		this.movimentacaoID = movimentacaoID;
	}
}