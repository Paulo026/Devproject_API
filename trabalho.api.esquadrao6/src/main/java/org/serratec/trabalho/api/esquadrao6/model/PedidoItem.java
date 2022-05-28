package org.serratec.trabalho.api.esquadrao6.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "PEDIDO")
public class PedidoItem {
    //Atributos da tabela (sem relações)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "pedido_id")
    private Integer pedidoId;

    @NotNull
    @Column(name = "pedido_data")
    private LocalDate pedidoData;

    @NotNull
    @Column(name = "pedido_numero")
    private Integer pedidoNumero;

    @NotNull
    @Column(name = "item_qt_comprada")
    private Integer itemQuantidadeComprada;

    @NotNull
    @Column(name = "item_vl_unitario")
    private Double itemValorUnitario;


    //Relações com outras tabelas --> Verificar relações e aplicar depois
    @NotNull
    @Column(name = "cliente_id")
    private Integer clienteId;

    @NotNull
    @Column(name = "produto_id")
    private Integer produtoId;


    //Construtor vazio
    public PedidoItem() {
    }

    //Getters e Setters
    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public LocalDate getPedidoData() {
        return pedidoData;
    }

    public void setPedidoData(LocalDate pedidoData) {
        this.pedidoData = pedidoData;
    }

    public Integer getPedidoNumero() {
        return pedidoNumero;
    }

    public void setPedidoNumero(Integer pedidoNumero) {
        this.pedidoNumero = pedidoNumero;
    }

    public Integer getItemQuantidadeComprada() {
        return itemQuantidadeComprada;
    }

    public void setItemQuantidadeComprada(Integer itemQuantidadeComprada) {
        this.itemQuantidadeComprada = itemQuantidadeComprada;
    }

    public Double getItemValorUnitario() {
        return itemValorUnitario;
    }

    public void setItemValorUnitario(Double itemValorUnitario) {
        this.itemValorUnitario = itemValorUnitario;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }
}
