package org.serratec.trabalho.api.esquadrao6.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
    //Atributos da tabela (sem relações)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "cliente_id")
    private Integer clienteId;

    @NotNull
    @Column(name = "cliente_nome")
    @Size(max = 100)
    private String clienteNome;

    @NotNull
    @Column(name = "cliente_usuario")
    @Size(max = 100)
    private String clienteUsuario;

    @NotNull
    @Column(name = "cliente_senha")
    @Size(min = 6, max = 20)
    private String clienteSenha;

    @NotNull
    @Column(name = "cliente_email")
    @Email
    @Size(max = 100)
    private String clienteEmail;

    @NotNull
    @Column(name = "cliente_cpf")
    @Size(min = 11, max = 11)
    private String clienteCpf;

    @NotNull
    @Column(name = "cliente_dt_nasc")
    private LocalDate clienteDataNascimento;

    @NotNull
    @Column(name = "cliente_telefone")
    @Size(min = 10, max = 11)
    private String clienteTelefone;

    @NotNull
    @Column(name = "cliente_endereco_completo")
    @Size(min = 20, max = 600)
    private String clienteEnderecoCompleto;

    @NotNull
    @Column(name = "cliente_cep")
    @Size(min = 8, max = 8)
    private String clienteCep;

    //Relações com outras tabelas --> Verificar relações e aplicar depois

    //Construtor vazio
    public Cliente() {
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
}
