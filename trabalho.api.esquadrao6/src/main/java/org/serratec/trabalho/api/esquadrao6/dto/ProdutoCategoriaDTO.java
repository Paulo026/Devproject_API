package org.serratec.trabalho.api.esquadrao6.dto;

public class ProdutoCategoriaDTO {
    //Atributos específicos da classe
    private Integer categoriaId;
    private String categoriaNome;
    private String categoriaDescricao;

    //Atributos que se relacionam com outras classes
    private Integer idProduto;

    //Construtor Vazio
    public ProdutoCategoriaDTO() {
    }


    //Getters e Setters
    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public String getCategoriaDescricao() {
        return categoriaDescricao;
    }

    public void setCategoriaDescricao(String categoriaDescricao) {
        this.categoriaDescricao = categoriaDescricao;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }
}
