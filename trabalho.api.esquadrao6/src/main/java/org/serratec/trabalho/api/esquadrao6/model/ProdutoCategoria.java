package org.serratec.trabalho.api.esquadrao6.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "produto_categoria")
public class ProdutoCategoria {
    //Atributos da tabela (sem relações)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "categoria_id")
    private Integer categoriaId;

    @NotNull
    @Column(name = "categoria_nome")
    @Size(max = 100)
    private String categoriaNome;

    @NotNull
    @Column(name = "categoria_descricao")
    @Size(max = 500)
    private String categoriaDescricao;

    //Relações com outras tabelas --> Verificar relações e aplicar depois
    @OneToMany(mappedBy = "produtoCategoria")
    private List<Produto> listaProduto;


    //Construtor vazio
    public ProdutoCategoria() {
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

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }
}
