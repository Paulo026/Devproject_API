package org.serratec.trabalho.api.esquadrao6.dto;

import java.time.LocalDate;

public class ProdutoDTO {
	
	private Integer idProduto;
	private String nomeProduto;
	private String descricaoProduto;
	private Double valorUnitario;
	private LocalDate dataValidade;
	private Integer qtdeEstoque;
	
	public ProdutoDTO() {}
	
	

	public ProdutoDTO(Integer idProduto, String nomeProduto, String descricaoProduto, Double valorUnitario,
			LocalDate dataValidade, Integer qtdeEstoque) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.valorUnitario = valorUnitario;
		this.dataValidade = dataValidade;
		this.qtdeEstoque = qtdeEstoque;
	}


	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Integer getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setQtdeEstoque(Integer qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}
	
	
	
}
