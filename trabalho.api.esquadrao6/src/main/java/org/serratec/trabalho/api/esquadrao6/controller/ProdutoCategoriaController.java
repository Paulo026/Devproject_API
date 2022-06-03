package org.serratec.trabalho.api.esquadrao6.controller;




import org.serratec.trabalho.api.esquadrao6.dto.ClienteDTO;
import org.serratec.trabalho.api.esquadrao6.dto.ProdutoCategoriaDTO;
import org.serratec.trabalho.api.esquadrao6.exception.ProdutoCategoriaException;
import org.serratec.trabalho.api.esquadrao6.model.ProdutoCategoria;
import org.serratec.trabalho.api.esquadrao6.service.ProdutoCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtoCategoria")
public class ProdutoCategoriaController {

    @Autowired
    ProdutoCategoriaService produtoCategoriaService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody ProdutoCategoriaDTO produtoCategoriaDTO){
        return ResponseEntity.ok(produtoCategoriaService.salvar(produtoCategoriaDTO));
    }

    @GetMapping("/buscar/{idCliente}")
    public ResponseEntity<ProdutoCategoriaDTO> buscarPorId(@PathVariable Integer categoriaId) throws ProdutoCategoriaException {
        return ResponseEntity.ok(produtoCategoriaService.buscarPorId(categoriaId));
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<Void> deletar(@PathVariable Integer categoriaId){
        produtoCategoriaService.deletar(categoriaId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("atualizar/{categoriaId}")
    public ResponseEntity<String> atualizar(@PathVariable Integer categoriaId, @RequestBody ProdutoCategoriaDTO produtoCategoriaDTO)
            throws ProdutoCategoriaException {
        return ResponseEntity.ok(produtoCategoriaService.atualizar(categoriaId, produtoCategoriaDTO));
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ProdutoCategoriaDTO>> listarTodos(){
        return ResponseEntity.ok(produtoCategoriaService.buscarTodos());
    }

    @PostMapping("/salvar-lista")
    public ResponseEntity<Void> salvatLista(@RequestBody List<ProdutoCategoriaDTO> listaProdutoCategoriaDTO) throws ProdutoCategoriaException {
        produtoCategoriaService.salvarListaCategoria(listaProdutoCategoriaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}
