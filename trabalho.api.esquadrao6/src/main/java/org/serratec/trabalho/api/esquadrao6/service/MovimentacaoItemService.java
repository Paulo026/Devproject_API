package org.serratec.trabalho.api.esquadrao6.service;

import org.serratec.trabalho.api.esquadrao6.dto.MovimentacaoItemDTO;
import org.serratec.trabalho.api.esquadrao6.dto.RelatorioDTO;
import org.serratec.trabalho.api.esquadrao6.exception.EmailException;
import org.serratec.trabalho.api.esquadrao6.exception.MovimentacaoItemException;
import org.serratec.trabalho.api.esquadrao6.model.MovimentacaoItem;
import org.serratec.trabalho.api.esquadrao6.model.Produto;
import org.serratec.trabalho.api.esquadrao6.repository.ClienteRepository;
import org.serratec.trabalho.api.esquadrao6.repository.MovimentacaoItemRepository;
import org.serratec.trabalho.api.esquadrao6.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoItemService {

	@Autowired
	MovimentacaoItemRepository movItemRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ProdutoService produtoService;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	EmailService email;

	// CRUD
	public MovimentacaoItemDTO buscarMovimentacaoPorID(Integer movID) {
		Optional<MovimentacaoItem> movItem = movItemRepository.findById(movID);
		MovimentacaoItem movSalva = new MovimentacaoItem();
		MovimentacaoItemDTO dtoMovItem = new MovimentacaoItemDTO();

		if (movItem.isPresent()) {
			movSalva = movItem.get();
			movimentacaoModelDTO(movSalva, dtoMovItem);
		}
		return dtoMovItem;
	}

	public List<MovimentacaoItemDTO> buscarTodasMovimentacoes() {
		List<MovimentacaoItem> listaMov = movItemRepository.findAll();
		List<MovimentacaoItemDTO> dtoListaMov = new ArrayList<>();

		for (MovimentacaoItem movItem : listaMov) {
			MovimentacaoItemDTO dtoMovItem = new MovimentacaoItemDTO();
			movimentacaoDTOModel(movItem, dtoMovItem);
			dtoListaMov.add(dtoMovItem);
		}
		return dtoListaMov;
	}

	// Movimentos da Loja
	public String movimentarProduto(MovimentacaoItemDTO dtoMovItem)
			throws MessagingException, EmailException, MovimentacaoItemException {
		MovimentacaoItem movItem = new MovimentacaoItem();
		movimentacaoDTOModel(movItem, dtoMovItem);

		movItemRepository.save(movItem);

		Optional<Produto> produto = produtoRepository.findById(dtoMovItem.getProdutoID());
		Produto produtoBanco = new Produto();
		if (produto.isPresent()) {
			produtoBanco = produto.get();
			if (dtoMovItem.getMovimentacaoTipo().equalsIgnoreCase("COMPRA")) {
				if (dtoMovItem.getMovimentacaoQuantidade() != null) {
					produtoBanco.setProdutoQuantidadeEstoque(movItem.getProduto().getProdutoQuantidadeEstoque()
							+ dtoMovItem.getMovimentacaoQuantidade());
					produtoBanco.setProdutoValorUnitario(movItem.getMovimentacaoValorUnitario());
					produtoRepository.save(produtoBanco);
				}
			}
			if (dtoMovItem.getMovimentacaoTipo().equalsIgnoreCase("VENDA")) {
				if (dtoMovItem.getMovimentacaoQuantidade() > produtoBanco.getProdutoQuantidadeEstoque()) {
					throw new MovimentacaoItemException("Quantidade vendida ?? maior que a quantidade em estoque");
				} else {
					if (dtoMovItem.getMovimentacaoQuantidade() != null) {
						produtoBanco.setProdutoQuantidadeEstoque(movItem.getProduto().getProdutoQuantidadeEstoque()
								- dtoMovItem.getMovimentacaoQuantidade());
						movimentacaoModelDTO(movItem, dtoMovItem);
						email.emailVendaConcluida(dtoMovItem);
						if (produtoBanco.getProdutoQuantidadeEstoque() <= 5) {
							email.emailFaltaEstoque(dtoMovItem);
						}
						produtoRepository.save(produtoBanco);
					}
				}
			}
		}
		return movItem.getMovimentacaoTipo() + " cadastrada com sucesso";
	}

	// Relat??rios
	public List<RelatorioDTO> relatorioProdutosMaisVendidos() {
		return movItemRepository.relatorioProdutosMaisVendidos();
	}

	// Conversores
	public MovimentacaoItemDTO movimentacaoModelDTO(MovimentacaoItem movItem, MovimentacaoItemDTO dtoMovItem) {
		dtoMovItem.setMovimentacaoID(movItem.getMovimentacaoID());
		dtoMovItem.setMovimentacaoData(movItem.getMovimentacaoData());
		dtoMovItem.setMovimentacaoTipo(movItem.getMovimentacaoTipo());
		dtoMovItem.setMovimentacaoQuantidade(movItem.getMovimentacaoQuantidade());
		dtoMovItem.setMovimentacaoValorUnitario(movItem.getMovimentacaoValorUnitario());
		dtoMovItem.setMovimentacaoNumeroDocumento(movItem.getMovimentacaoNumeroDocumento());

		dtoMovItem.setClienteID(movItem.getCliente().getClienteId());
		dtoMovItem.setClienteNome(movItem.getCliente().getClienteNome());
		dtoMovItem.setProdutoID(movItem.getProduto().getProdutoId());
		dtoMovItem.setProdutoNome(movItem.getProduto().getProdutoNome());

		return dtoMovItem;
	}

	public MovimentacaoItem movimentacaoDTOModel(MovimentacaoItem movItem, MovimentacaoItemDTO dtoMovItem) {
		movItem.setMovimentacaoID(dtoMovItem.getMovimentacaoID());
		movItem.setMovimentacaoData(dtoMovItem.getMovimentacaoData());
		movItem.setMovimentacaoTipo(dtoMovItem.getMovimentacaoTipo());
		movItem.setMovimentacaoQuantidade(dtoMovItem.getMovimentacaoQuantidade());
		movItem.setMovimentacaoValorUnitario(dtoMovItem.getMovimentacaoValorUnitario());
		movItem.setMovimentacaoNumeroDocumento(dtoMovItem.getMovimentacaoNumeroDocumento());

		movItem.setCliente(clienteRepository.findById(dtoMovItem.getClienteID()).get());
		movItem.setProduto(produtoRepository.findById(dtoMovItem.getProdutoID()).get());

		return movItem;
	}

}
