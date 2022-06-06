package org.serratec.trabalho.api.esquadrao6.service;

import org.serratec.trabalho.api.esquadrao6.dto.ProdutoDTO;
import org.serratec.trabalho.api.esquadrao6.exception.ProdutoException;
import org.serratec.trabalho.api.esquadrao6.model.Produto;
import org.serratec.trabalho.api.esquadrao6.repository.FuncionarioRepository;
import org.serratec.trabalho.api.esquadrao6.repository.ProdutoCategoriaRepository;
import org.serratec.trabalho.api.esquadrao6.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Autowired
	ProdutoCategoriaRepository pCategoriaRepository;

	public ProdutoDTO transformarModelEmDTO(Produto produto, ProdutoDTO produtoDTO) {
		produtoDTO.setProdutoId(produto.getProdutoId());
		produtoDTO.setProdutoNome(produto.getProdutoNome());
		produtoDTO.setProdutoDescricao(produto.getProdutoDescricao());
		produtoDTO.setProdutoQuantidadeEstoque(produto.getProdutoQuantidadeEstoque());
		produtoDTO.setProdutoDataFabricacao(produto.getProdutoDataFabricacao());
		produtoDTO.setProdutoDataValidade(produto.getProdutoDataValidade());
		produtoDTO.setProdutoValorUnitario(produto.getProdutoValorUnitario());
		produtoDTO.setCategoriaID(produto.getProdutoCategoria().getCategoriaId());
		produtoDTO.setCategoriaNome(produto.getProdutoCategoria().getCategoriaNome());
		produtoDTO.setFuncionarioID(produto.getFuncionario().getFuncionarioId());
		produtoDTO.setFuncionarioNome(produto.getFuncionario().getFuncionarioNome());

		// Verificar ligações
		return produtoDTO;
	}

	// Verificar ligações
	public Produto transformarDTOEmModel(Produto produto, ProdutoDTO produtoDTO) throws ProdutoException {
		if (produtoDTO.getProdutoNome() == null) {
			throw new ProdutoException("O nome do produto não foi informado");
		}
		if (produtoDTO.getProdutoDescricao() == null) {
			throw new ProdutoException("A descrição não foi informada");
		}
		if (produtoDTO.getProdutoQuantidadeEstoque() == null) {
			throw new ProdutoException("A quantidade em estoque não foi informada");
		}
		if (produtoDTO.getProdutoDataFabricacao() == null) {
			throw new ProdutoException("A data de fabricação não foi informada");
		}
		if (produtoDTO.getProdutoDataValidade() == null) {
			throw new ProdutoException("A data de validade não foi informada");
		}
		if (produtoDTO.getProdutoValorUnitario() == null) {
			throw new ProdutoException("O valor unitário não foi informado");
		}

		produto.setProdutoNome(produtoDTO.getProdutoNome());
		produto.setProdutoDescricao(produtoDTO.getProdutoDescricao());
		produto.setProdutoQuantidadeEstoque(produtoDTO.getProdutoQuantidadeEstoque());
		produto.setProdutoDataFabricacao(produtoDTO.getProdutoDataFabricacao());
		produto.setProdutoDataValidade(produtoDTO.getProdutoDataValidade());
		produto.setProdutoValorUnitario(produtoDTO.getProdutoValorUnitario());

		if (produtoDTO.getFuncionarioID() != null) {
			produto.setFuncionario(funcionarioRepository.findById(produtoDTO.getFuncionarioID()).get());
		}

		if (produtoDTO.getCategoriaID() != null) {
			produto.setProdutoCategoria(pCategoriaRepository.findById(produtoDTO.getCategoriaID()).get());
		}
		return produto;
	}

	public String salvar(ProdutoDTO produtoDTO) throws ProdutoException {
		Produto noBanco = produtoRepository.recuperarNome(produtoDTO.getProdutoNome());
		if (noBanco != null) {
			noBanco.setProdutoQuantidadeEstoque(
					noBanco.getProdutoQuantidadeEstoque() + produtoDTO.getProdutoQuantidadeEstoque());
			produtoRepository.save(noBanco);
			return "Produto já estava cadastrado (id: " + noBanco.getProdutoId()
					+ "). O estoque foi atualizado com sucesso!";
		}

		Produto produto = new Produto();
		transformarDTOEmModel(produto, produtoDTO);
		produtoRepository.save(produto);
		return "O produto foi criado com uma ID: " + produto.getProdutoId();
	}

	public ProdutoDTO buscarPorId(Integer idProduto) throws ProdutoException {
		Optional<Produto> produto = produtoRepository.findById(idProduto);
		Produto produtoNoBanco = new Produto();
		ProdutoDTO produtoDTO = new ProdutoDTO();
		if (produto.isPresent()) {
			produtoNoBanco = produto.get();
			transformarModelEmDTO(produtoNoBanco, produtoDTO);
			return produtoDTO;
		}
		throw new ProdutoException("O produto com o id informado não foi encontrado");
	}

	public void deletar(Integer idProduto) {
		produtoRepository.deleteById(idProduto);
	}

	public String atualizar(Integer idProduto, ProdutoDTO produtoDTO) throws ProdutoException {
		Optional<Produto> produto = produtoRepository.findById(idProduto);
		Produto produtoBanco = new Produto();
		if (produto.isPresent()) {
			produtoBanco = produto.get();
			if (produtoDTO.getProdutoNome() != null) {
				produtoBanco.setProdutoNome(produtoDTO.getProdutoNome());
			}
			if (produtoDTO.getProdutoDescricao() != null) {
				produtoBanco.setProdutoDescricao(produtoDTO.getProdutoDescricao());
			}
			if (produtoDTO.getProdutoQuantidadeEstoque() != null) {
				produtoBanco.setProdutoQuantidadeEstoque(produtoDTO.getProdutoQuantidadeEstoque());
			}
			if (produtoDTO.getProdutoDataFabricacao() != null) {
				produtoBanco.setProdutoDataFabricacao(produtoDTO.getProdutoDataFabricacao());
			}
			if (produtoDTO.getProdutoDataValidade() != null) {
				produtoBanco.setProdutoDataValidade(produtoDTO.getProdutoDataValidade());
			}
			if (produtoDTO.getProdutoValorUnitario() != null) {
				produtoBanco.setProdutoValorUnitario(produtoDTO.getProdutoValorUnitario());
			}
			produtoRepository.save(produtoBanco);
			return "O produto com o id " + produtoBanco.getProdutoId() + " foi atualizado!";
		}
		throw new ProdutoException("O produto não foi atualizado.");
	}

	public List<ProdutoDTO> buscarTodos() {
		List<Produto> produtoListaModel = produtoRepository.findAll();
		List<ProdutoDTO> produtoListaDTO = new ArrayList<>();
		for (Produto produto : produtoListaModel) {
			ProdutoDTO produtoDTO = new ProdutoDTO();
			transformarModelEmDTO(produto, produtoDTO);
			produtoListaDTO.add(produtoDTO);
		}
		return produtoListaDTO;
	}

	public void salvarListaProduto(List<ProdutoDTO> listaProdutoDTO) throws ProdutoException {
		List<Produto> listaProduto = new ArrayList<>();

		for (ProdutoDTO produtoDTO : listaProdutoDTO) {
			Produto produto = new Produto();
			transformarDTOEmModel(produto, produtoDTO);
			listaProduto.add(produto);
		}
		produtoRepository.saveAll(listaProduto);
	}

}