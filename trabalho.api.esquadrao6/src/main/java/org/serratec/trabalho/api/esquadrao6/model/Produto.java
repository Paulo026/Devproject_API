package org.serratec.trabalho.api.esquadrao6.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "PRODUTO")
public class Produto {
    //Atributos da tabela (sem relações)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "produto_id")
    private Integer produtoId;

    @NotNull
    @Column(name = "produto_nome")
    @Size(max = 100)
    private String produtoNome;

    @NotNull
    @Column(name = "produto_descricao")
    @Size(max = 500)
    private String produtoDescricao;

    @NotNull
    @Column(name = "produto_qt_estoque")
    private Integer produtoQuantidadeEstoque;

    @NotNull
    @Column(name = "produto_dt_fabricacao")
    private LocalDate produtoDataFabricacao;

    @NotNull
    @Column(name = "produto_dt_validade")
    private LocalDate produtoDataValidade;

    @NotNull
    @Column(name = "produto_vl_unitario")
    private Double produtoValorUnitario;

    //Relações com outras tabelas --> Verificar relações e aplicar depois
    @NotNull
    @Column(name = "categoria_id")
    private Integer categoriaId;

    @NotNull
    @Column(name = "funcionario_id")
    private Integer FuncionarioId;

    //Construtor vazio
    public Produto() {
    }

    //Getters e Setters
    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public String getProdutoDescricao() {
        return produtoDescricao;
    }

    public void setProdutoDescricao(String produtoDescricao) {
        this.produtoDescricao = produtoDescricao;
    }

    public Integer getProdutoQuantidadeEstoque() {
        return produtoQuantidadeEstoque;
    }

    public void setProdutoQuantidadeEstoque(Integer produtoQuantidadeEstoque) {
        this.produtoQuantidadeEstoque = produtoQuantidadeEstoque;
    }

    public LocalDate getProdutoDataFabricacao() {
        return produtoDataFabricacao;
    }

    public void setProdutoDataFabricacao(LocalDate produtoDataFabricacao) {
        this.produtoDataFabricacao = produtoDataFabricacao;
    }

    public LocalDate getProdutoDataValidade() {
        return produtoDataValidade;
    }

    public void setProdutoDataValidade(LocalDate produtoDataValidade) {
        this.produtoDataValidade = produtoDataValidade;
    }

    public Double getProdutoValorUnitario() {
        return produtoValorUnitario;
    }

    public void setProdutoValorUnitario(Double produtoValorUnitario) {
        this.produtoValorUnitario = produtoValorUnitario;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Integer getFuncionarioId() {
        return FuncionarioId;
    }

    public void setFuncionarioId(Integer funcionarioId) {
        FuncionarioId = funcionarioId;
    }
}
