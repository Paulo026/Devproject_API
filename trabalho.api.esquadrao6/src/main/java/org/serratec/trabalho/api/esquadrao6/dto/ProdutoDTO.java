package org.serratec.trabalho.api.esquadrao6.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class ProdutoDTO implements Serializable {
    //Atributos específicos da classe
    private Integer produtoId;
    private String produtoNome;
    private String produtoDescricao;
    private Integer produtoQuantidadeEstoque;
    private LocalDate produtoDataFabricacao;
    private LocalDate produtoDataValidade;
    private Double produtoValorUnitario;

    //Atributos que se relacionam com outras classes
    private Integer categoriaID;
    private String categoriaNome;
    private Integer funcionarioID;
    private String funcionarioNome;

    //Construtor Vazio
    public ProdutoDTO() {
    }

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

    public Integer getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(Integer categoriaID) {
        this.categoriaID = categoriaID;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public Integer getFuncionarioID() {
        return funcionarioID;
    }

    public void setFuncionarioID(Integer funcionarioID) {
        this.funcionarioID = funcionarioID;
    }

    public String getFuncionarioNome() {
        return funcionarioNome;
    }

    public void setFuncionarioNome(String funcionarioNome) {
        this.funcionarioNome = funcionarioNome;
    }

}


