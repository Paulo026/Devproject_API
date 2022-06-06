package org.serratec.trabalho.api.esquadrao6.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "movimentacao_item")
public class MovimentacaoItem {
	// Atributos da tabela (sem relações)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_mov_id")
	private Integer movimentacaoID;

	@NotNull
	@Column(name = "mov_data")
	private LocalDate movimentacaoData;

	@NotNull
	@Column(name = "mov_num_doc")
	private Integer movimentacaoNumeroDocumento;

	@NotNull
	@Column(name = "mov_item_qt")
	private Integer movimentacaoQuantidade;

	@NotNull
	@Column(name = "mov_item_vl_unit")
	private Double movimentacaoValorUnitario;

	@NotNull
	@Size(max = 20)
	@Column(name = "mov_tipo")
	private String movimentacaoTipo;

	// Relações com outras tabelas --> Verificar relações e aplicar depois
	@ManyToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "produto_id", referencedColumnName = "produto_id")
	private Produto produto;

	// Construtor vazio
	public MovimentacaoItem() {
	}

	// Getters e Setters
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}