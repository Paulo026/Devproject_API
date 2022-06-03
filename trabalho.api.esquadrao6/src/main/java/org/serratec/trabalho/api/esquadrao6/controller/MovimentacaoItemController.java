package org.serratec.trabalho.api.esquadrao6.controller;


import org.serratec.trabalho.api.esquadrao6.dto.MovimentacaoItemDTO;
import org.serratec.trabalho.api.esquadrao6.dto.RelatorioDTO;
import org.serratec.trabalho.api.esquadrao6.service.MovimentacaoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacaoItem")
public class MovimentacaoItemController {
    @Autowired
    MovimentacaoItemService movimentacaoItemService;

    //CRUD

    //Movimentações da loja
    @PostMapping("/comprar")
    public ResponseEntity<String> comprarProduto (@RequestBody MovimentacaoItemDTO dtoMovItem) {

        return ResponseEntity.ok(movimentacaoItemService.comprarProduto(dtoMovItem));
    }

    @PostMapping("/vender")
    public ResponseEntity<String> venderProduto (@RequestBody MovimentacaoItemDTO dtoMovItem) {
        return ResponseEntity.ok(movimentacaoItemService.venderProduto(dtoMovItem));
    }

    //Relatórios
    @GetMapping("/relatorio/maisVendidos")
    public List<RelatorioDTO> relatorioProdutosMaisVendidos() {
        return movimentacaoItemService.relatorioProdutosMaisVendidos();
    }


}
