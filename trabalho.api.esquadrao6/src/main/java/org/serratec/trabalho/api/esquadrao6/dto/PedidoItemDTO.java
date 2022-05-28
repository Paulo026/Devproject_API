package org.serratec.trabalho.api.esquadrao6.dto;

import java.time.LocalDate;

public class PedidoItemDTO {
	
	private Integer pedidoId;
	private LocalDate pedidoData;
	private Integer pedidoNumero;
	private Integer itemQuantidadeComprada;
	private Double itemValorUnitario;
	private Integer clienteId;
	private Integer produtoId;
	
	public PedidoItemDTO() {}

	public PedidoItemDTO(Integer pedidoId, LocalDate pedidoData, Integer pedidoNumero, Integer itemQuantidadeComprada,
			Double itemValorUnitario, Integer clienteId, Integer produtoId) {
		super();
		this.pedidoId = pedidoId;
		this.pedidoData = pedidoData;
		this.pedidoNumero = pedidoNumero;
		this.itemQuantidadeComprada = itemQuantidadeComprada;
		this.itemValorUnitario = itemValorUnitario;
		this.clienteId = clienteId;
		this.produtoId = produtoId;
	}

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
