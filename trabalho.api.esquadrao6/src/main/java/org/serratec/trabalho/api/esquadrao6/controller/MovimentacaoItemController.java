package org.serratec.trabalho.api.esquadrao6.controller;

import org.serratec.trabalho.api.esquadrao6.dto.MovimentacaoItemDTO;
import org.serratec.trabalho.api.esquadrao6.dto.RelatorioDTO;
import org.serratec.trabalho.api.esquadrao6.exception.EmailException;
import org.serratec.trabalho.api.esquadrao6.exception.MovimentacaoItemException;
import org.serratec.trabalho.api.esquadrao6.service.MovimentacaoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/movimentacaoItem")
public class MovimentacaoItemController {

	@Autowired
	MovimentacaoItemService movimentacaoItemService;

	// CRUD
	@PostMapping("/movimentar")
	public ResponseEntity<String> movimentarProduto(@RequestBody MovimentacaoItemDTO dtoMovItem)
			throws MessagingException, EmailException, MovimentacaoItemException {
		return ResponseEntity.ok(movimentacaoItemService.movimentarProduto(dtoMovItem));
	}

	// Relatórios
	@GetMapping("/relatorio/maisVendidos")
	public List<RelatorioDTO> relatorioProdutosMaisVendidos() {
		return movimentacaoItemService.relatorioProdutosMaisVendidos();
	}

}
