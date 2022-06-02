package org.serratec.trabalho.api.esquadrao6.service;

import org.serratec.trabalho.api.esquadrao6.dto.RelatorioDTO;
import org.serratec.trabalho.api.esquadrao6.repository.MovimentacaoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MovimentacaoItemService {

    @Autowired
    MovimentacaoItemRepository movimentacaoItemRepository;
    //CRUD



    //Relatórios
    public List<RelatorioDTO> relatorioProdutosMaisVendidos() {
        return movimentacaoItemRepository.relatorioProdutosMaisVendidos();
    }

    //Conversores



}
