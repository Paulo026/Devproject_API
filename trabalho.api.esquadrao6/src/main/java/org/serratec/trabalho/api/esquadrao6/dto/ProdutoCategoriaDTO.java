package org.serratec.trabalho.api.esquadrao6.dto;

import java.io.Serializable;

public class ProdutoCategoriaDTO implements Serializable {
   
	private static final long serialVersionUID = 1L;
	//Atributos específicos da classe
    private Integer categoriaId;
    private String categoriaNome;
    private String categoriaDescricao;



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

}
