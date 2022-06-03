package org.serratec.trabalho.api.esquadrao6.controller;


import org.serratec.trabalho.api.esquadrao6.dto.ClienteDTO;
import org.serratec.trabalho.api.esquadrao6.exception.ClienteException;
import org.serratec.trabalho.api.esquadrao6.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody ClienteDTO clienteDTO) throws ClienteException{
        return ResponseEntity.ok(clienteService.salvar(clienteDTO));
    }

    @GetMapping("/buscar/{idCliente}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Integer idCliente) throws ClienteException{
        return ResponseEntity.ok(clienteService.buscarporId(idCliente));
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<Void> deletar(@PathVariable Integer idCliente){
        clienteService.deletar(idCliente);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("atualizar/{idCliente}")
    public ResponseEntity<String> atualizar(@PathVariable Integer idCliente, @RequestBody ClienteDTO clienteDTO)
        throws ClienteException{
        return ResponseEntity.ok(clienteService.atualizar(idCliente, clienteDTO));
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ClienteDTO>> listarTodos(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @PostMapping("/salvar-lista")
    public ResponseEntity<Void> salvatLista(@RequestBody List<ClienteDTO> listaClienteDTO) throws ClienteException {
        clienteService.salvarListaCLiente(listaClienteDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
