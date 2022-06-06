package org.serratec.trabalho.api.esquadrao6.controller;

import java.util.List;

import org.serratec.trabalho.api.esquadrao6.dto.FuncionarioDTO;
import org.serratec.trabalho.api.esquadrao6.exception.FuncionarioException;
import org.serratec.trabalho.api.esquadrao6.service.FuncionarioService;
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
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;


	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody FuncionarioDTO funcionarioDTO) throws FuncionarioException {
		return ResponseEntity.ok(funcionarioService.salvar(funcionarioDTO));
	}

	@GetMapping("/buscar/{funcionarioId}")
	public ResponseEntity<FuncionarioDTO> buscarPorId(@PathVariable Integer funcionarioId) throws FuncionarioException {
		return ResponseEntity.ok(funcionarioService.buscarPorId(funcionarioId));
	}

	@DeleteMapping("/{funcionarioId}")
	public ResponseEntity<Void> deletar(@PathVariable Integer funcionarioId) {
		funcionarioService.deletar(funcionarioId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@PutMapping("atualizar/{funcionarioId}")
	public ResponseEntity<String> atualizar(@PathVariable Integer funcionarioId,
			@RequestBody FuncionarioDTO funcionarioDTO) throws FuncionarioException {
		return ResponseEntity.ok(funcionarioService.atualizar(funcionarioId, funcionarioDTO));
	}

	@GetMapping("/lista")
	public ResponseEntity<List<FuncionarioDTO>> listarTodos() {
		return ResponseEntity.ok(funcionarioService.buscarTodos());
	}

	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<FuncionarioDTO> listafuncionarioDTO)
			throws FuncionarioException {
		funcionarioService.salvarListaFuncionario(listafuncionarioDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
