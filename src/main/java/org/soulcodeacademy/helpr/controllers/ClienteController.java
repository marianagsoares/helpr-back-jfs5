package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.dto.ClienteDTO;
import org.soulcodeacademy.helpr.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // coletar as requisições
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> mostrarLista() {
        return this.clienteService.listarTodos();
    }

    @GetMapping("/clientes/{idCliente}")
    public Cliente getCliente(@PathVariable Integer idCliente){
        return this.clienteService.getCliente(idCliente);
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> salvarCliente(@Valid @RequestBody ClienteDTO dto) {
        Cliente cliente = this.clienteService.salvar(dto);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @PutMapping("/clientes/{idCliente}")
    public Cliente atualizar(@PathVariable Integer idCliente, @Valid @RequestBody ClienteDTO dto) {
        Cliente atualizado = this.clienteService.atualizar(idCliente, dto);
        return atualizado; // CORPO da Resposta em JSON
    }

    @DeleteMapping("/clientes/{idCliente}")
    public ResponseEntity<Void> deletar(@PathVariable Integer idCliente) {

        this.clienteService.deletar(idCliente);
        return ResponseEntity.noContent().build();
    }
}
// Deserializar => JSON -> Classe
// Serializar => Classe -> JSON