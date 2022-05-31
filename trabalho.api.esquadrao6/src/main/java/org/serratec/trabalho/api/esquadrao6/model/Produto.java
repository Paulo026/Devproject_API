package org.serratec.trabalho.api.esquadrao6.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

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

    //Relações com outras tabelas --> Relações verificadas
    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
    private ProdutoCategoria produtoCategoria;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "funcionario_id")
    private Funcionario funcionario;

    @OneToMany(mappedBy = "produto")
    private List<MovimentacaoItem> listaMovimentacao;


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

    public ProdutoCategoria getProdutoCategoria() {
        return produtoCategoria;
    }

    public void setProdutoCategoria(ProdutoCategoria produtoCategoria) {
        this.produtoCategoria = produtoCategoria;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<MovimentacaoItem> getListaMovimentacao() {
        return listaMovimentacao;
    }

    public void setListaMovimentacao(List<MovimentacaoItem> listaMovimentacao) {
        this.listaMovimentacao = listaMovimentacao;
    }
}
