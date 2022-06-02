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
    ClienteRepository cliente;

    @Autowired
    ProdutoRepository produto;

    @Autowired
    EmailService email;

    //CRUD
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

    public List<MovimentacaoItemDTO> buscarTodasMovimentacoes (Integer movID) {
        List<MovimentacaoItem> listaMov = movItemRepository.findAll();
        List<MovimentacaoItemDTO> dtoListaMov = new ArrayList<>();

        for (MovimentacaoItem movItem : listaMov) {
            MovimentacaoItemDTO dtoMovItem = new MovimentacaoItemDTO();
            movimentacaoDTOModel(movItem, dtoMovItem);
            dtoListaMov.add(dtoMovItem);
        }
        return dtoListaMov;
    }



    //Relatórios
    public List<RelatorioDTO> relatorioProdutosMaisVendidos() {
        return movItemRepository.relatorioProdutosMaisVendidos();
    }

    //Conversores
    public MovimentacaoItemDTO movimentacaoModelDTO(MovimentacaoItem movItem, MovimentacaoItemDTO dtoMovItem) {
        dtoMovItem.setMovimentacaoID(movItem.getMovimentacaoID());
        dtoMovItem.setMovimentacaoData(movItem.getMovimentacaoData());
        dtoMovItem.setMovimentacaoTipo(movItem.getMovimentacaoTipo());
        dtoMovItem.setMovimentacaoQuantidade(movItem.getMovimentacaoQuantidade());
        dtoMovItem.setMovimentacaoValorUnitario(movItem.getMovimentacaoValorUnitario());
        dtoMovItem.setMovimentacaoNumeroDocumento(movItem.getMovimentacaoNumeroDocumento());

        dtoMovItem.setClienteID(movItem.getCliente().getClienteId());
        dtoMovItem.setProdutoID(movItem.getProduto().getProdutoId());

        return dtoMovItem;
    }

    public MovimentacaoItem movimentacaoDTOModel(MovimentacaoItem movItem, MovimentacaoItemDTO dtoMovItem) {
        movItem.setMovimentacaoID(dtoMovItem.getMovimentacaoID());
        movItem.setMovimentacaoData(dtoMovItem.getMovimentacaoData());
        movItem.setMovimentacaoTipo(dtoMovItem.getMovimentacaoTipo());
        movItem.setMovimentacaoQuantidade(dtoMovItem.getMovimentacaoQuantidade());
        movItem.setMovimentacaoValorUnitario(dtoMovItem.getMovimentacaoValorUnitario());
        movItem.setMovimentacaoNumeroDocumento(dtoMovItem.getMovimentacaoNumeroDocumento());

        movItem.setCliente(cliente.findById(dtoMovItem.getClienteID()).get());
        movItem.setProduto(produto.findById(dtoMovItem.getProdutoID()).get());

        return movItem;
    }


}
