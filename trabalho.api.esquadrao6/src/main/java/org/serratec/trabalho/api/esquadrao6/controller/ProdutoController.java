package org.serratec.trabalho.api.esquadrao6.controller;

import java.util.List;

import org.serratec.trabalho.api.esquadrao6.dto.ProdutoDTO;
import org.serratec.trabalho.api.esquadrao6.exception.ProdutoException;
import org.serratec.trabalho.api.esquadrao6.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody ProdutoDTO produtoDTO){
		return ResponseEntity.ok(produtoService.salvar(produtoDTO));
	}
	
	@GetMapping("/buscar/{idProduto}")
	public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable Integer idProduto) throws ProdutoException{
		return ResponseEntity.ok(produtoService.buscarPorId(idProduto));
	}
	
	@DeleteMapping("/{idProduto}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idProduto){
		produtoService.deletar(idProduto);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/atualizar/{idProduto}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idProduto, @RequestBody ProdutoDTO produtoDTO ) throws ProdutoException{
		return ResponseEntity.ok(produtoService.atualizar(idProduto, produtoDTO));
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<ProdutoDTO>> listaTodos(){
		return ResponseEntity.ok(produtoService.buscarTodos());
	}
	
	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<ProdutoDTO> listaProdutoDTO){
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
