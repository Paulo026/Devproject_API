package org.serratec.trabalho.api.esquadrao6.service;

import org.serratec.trabalho.api.esquadrao6.dto.MovimentacaoItemDTO;
import org.serratec.trabalho.api.esquadrao6.dto.RelatorioDTO;
import org.serratec.trabalho.api.esquadrao6.model.MovimentacaoItem;
import org.serratec.trabalho.api.esquadrao6.repository.ClienteRepository;
import org.serratec.trabalho.api.esquadrao6.repository.MovimentacaoItemRepository;
import org.serratec.trabalho.api.esquadrao6.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //CRUD
    public MovimentacaoItemDTO buscarMovimentacaoPorID(Integer movID) {
        Optional<MovimentacaoItem> movItem = movItemRepository.findById(movID);
        MovimentacaoItem movSalva = new MovimentacaoItem();
        MovimentacaoItemDTO DTOMovItem = new MovimentacaoItemDTO();

        if (movItem.isPresent()) {
            movSalva = movItem.get();
            movimentacaoModelDTO(movSalva, DTOMovItem);
        }
        return DTOMovItem;
    }

    public List<MovimentacaoItemDTO> buscarTodasMovimentacoes(Integer movID) {
        List<MovimentacaoItem> listaMov = movItemRepository.findAll();
        List<MovimentacaoItemDTO> dtoListaMov = new ArrayList<>();

        for (MovimentacaoItem movItem : listaMov) {
            MovimentacaoItemDTO dtoMovItem = new MovimentacaoItemDTO();
            movimentacaoDTOModel(movItem, dtoMovItem);
            dtoListaMov.add(dtoMovItem);
        }
        return dtoListaMov;
    }

    //Movimentos da Loja
    public String comprarProduto(MovimentacaoItemDTO dtoMovItem) { //TODO registra o movimento, mas não diminui o estoque
        MovimentacaoItem movItem = new MovimentacaoItem();
        movimentacaoDTOModel(movItem, dtoMovItem);

        movItemRepository.save(movItem);
        produtoService.atualizarEstoque(dtoMovItem.getProdutoID(), dtoMovItem.getMovimentacaoQuantidade());

        return "Compra registrada com sucesso!";
    }

    public String venderProduto(MovimentacaoItemDTO dtoMovItem) { //TODO registra o movimento, mas não diminui o estoque
        MovimentacaoItem movItem = new MovimentacaoItem();
        movimentacaoDTOModel(movItem, dtoMovItem);

        movItemRepository.save(movItem);
        produtoService.atualizarEstoque(dtoMovItem.getProdutoID(), -(dtoMovItem.getMovimentacaoQuantidade()));

        return "Venda registrada com sucesso!";
    }


    //Relatórios
    public List<RelatorioDTO> relatorioProdutosMaisVendidos() {
        return movItemRepository.relatorioProdutosMaisVendidos();
    }

    //Conversores
    public MovimentacaoItemDTO movimentacaoModelDTO(MovimentacaoItem movItem, MovimentacaoItemDTO DTOMovItem) {
        DTOMovItem.setMovimentacaoID(movItem.getMovimentacaoID());
        DTOMovItem.setMovimentacaoData(movItem.getMovimentacaoData());
        DTOMovItem.setMovimentacaoTipo(movItem.getMovimentacaoTipo());
        DTOMovItem.setMovimentacaoQuantidade(movItem.getMovimentacaoQuantidade());
        DTOMovItem.setMovimentacaoValorUnitario(movItem.getMovimentacaoValorUnitario());
        DTOMovItem.setMovimentacaoNumeroDocumento(movItem.getMovimentacaoNumeroDocumento());

        DTOMovItem.setClienteID(movItem.getCliente().getClienteId());
        DTOMovItem.setProdutoID(movItem.getProduto().getProdutoId());

        return DTOMovItem;
    }

    public MovimentacaoItem movimentacaoDTOModel(MovimentacaoItem movItem, MovimentacaoItemDTO DTOMovItem) {
        movItem.setMovimentacaoID(DTOMovItem.getMovimentacaoID());
        movItem.setMovimentacaoData(DTOMovItem.getMovimentacaoData());
        movItem.setMovimentacaoTipo(DTOMovItem.getMovimentacaoTipo());
        movItem.setMovimentacaoQuantidade(DTOMovItem.getMovimentacaoQuantidade());
        movItem.setMovimentacaoValorUnitario(DTOMovItem.getMovimentacaoValorUnitario());
        movItem.setMovimentacaoNumeroDocumento(DTOMovItem.getMovimentacaoNumeroDocumento());

        movItem.setCliente(clienteRepository.findById(DTOMovItem.getClienteID()).get());
        movItem.setProduto(produtoRepository.findById(DTOMovItem.getProdutoID()).get());

        return movItem;
    }


}
