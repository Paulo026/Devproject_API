package org.serratec.trabalho.api.esquadrao6.dto;

import java.time.LocalDate;

public class MovimentacaoItemDTO {
    //Atributos específicos da classe
    private Integer movimentacaoID;
    private LocalDate movimentacaoData;
    private Integer movimentacaoNumeroDocumento;
    private Integer movimentacaoQuantidade;
    private Double movimentacaoValorUnitario;
    private String movimentacaoTipo;

    //Atributos que se relacionam com outras classes
    private Integer clienteID;
    private Integer produtoID;

    //Construtor Vazio
    public MovimentacaoItemDTO() {
    }


    //Getters e Setters
    public Integer getMovimentacaoID() {
        return movimentacaoID;
    }

    public void setMovimentacaoID(Integer movimentacaoID) {
        this.movimentacaoID = movimentacaoID;
    }

    public LocalDate getMovimentacaoData() {
        return movimentacaoData;
    }

    public void setMovimentacaoData(LocalDate movimentacaoData) {
        this.movimentacaoData = movimentacaoData;
    }

    public Integer getMovimentacaoNumeroDocumento() {
        return movimentacaoNumeroDocumento;
    }

    public void setMovimentacaoNumeroDocumento(Integer movimentacaoNumeroDocumento) {
        this.movimentacaoNumeroDocumento = movimentacaoNumeroDocumento;
    }

    public Integer getMovimentacaoQuantidade() {
        return movimentacaoQuantidade;
    }

    public void setMovimentacaoQuantidade(Integer movimentacaoQuantidade) {
        this.movimentacaoQuantidade = movimentacaoQuantidade;
    }

    public Double getMovimentacaoValorUnitario() {
        return movimentacaoValorUnitario;
    }

    public void setMovimentacaoValorUnitario(Double movimentacaoValorUnitario) {
        this.movimentacaoValorUnitario = movimentacaoValorUnitario;
    }

    public String getMovimentacaoTipo() {
        return movimentacaoTipo;
    }

    public void setMovimentacaoTipo(String movimentacaoTipo) {
        this.movimentacaoTipo = movimentacaoTipo;
    }

    public Integer getClienteID() {
        return clienteID;
    }

    public void setClienteID(Integer clienteID) {
        this.clienteID = clienteID;
    }

    public Integer getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(Integer produtoID) {
        this.produtoID = produtoID;
    }
}
