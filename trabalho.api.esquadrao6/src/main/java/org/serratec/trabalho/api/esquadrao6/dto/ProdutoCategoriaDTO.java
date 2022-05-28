package org.serratec.trabalho.api.esquadrao6.dto;

public class ProdutoCategoriaDTO {
	
	private Integer categoriaId;
	private String categoriaNome;
	private String categoriaDescricao;
	
	public ProdutoCategoriaDTO() {}

	public ProdutoCategoriaDTO(Integer categoriaId, String categoriaNome, String categoriaDescricao) {
		super();
		this.categoriaId = categoriaId;
		this.categoriaNome = categoriaNome;
		this.categoriaDescricao = categoriaDescricao;
	}

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
