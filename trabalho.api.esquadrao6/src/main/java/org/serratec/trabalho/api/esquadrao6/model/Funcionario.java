package org.serratec.trabalho.api.esquadrao6.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {
    //Atributos da tabela (sem relações)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "funcionario_id")
    private Integer FuncionarioId;

    @NotNull
    @Column(name = "funcionario_nome")
    @Size(max = 100)
    private String funcionarioNome;

    @NotNull
    @Column(name = "funcionario_cpf")
    @Size(min = 11, max = 11)
    private String funcionarioCpf;

    //Relações com outras tabelas --> Verificar relações e aplicar depois


    //Construtor vazio
    public Funcionario() {
    }

    //Getters e Setters
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
