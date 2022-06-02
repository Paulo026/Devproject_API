package org.serratec.trabalho.api.esquadrao6.controller;


import org.serratec.trabalho.api.esquadrao6.dto.RelatorioDTO;
import org.serratec.trabalho.api.esquadrao6.service.MovimentacaoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movimentacaoItem")
public class MovimentacaoItemController {
    @Autowired
    MovimentacaoItemService movimentacaoItemService;

    //CRUD


    //Relatórios
    @GetMapping("/relatorio/maisVendidos")
    public List<RelatorioDTO> relatorioProdutosMaisVendidos() {
        return movimentacaoItemService.relatorioProdutosMaisVendidos();
    }

}
