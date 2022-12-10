package org.soulcodeacademy.helpr.controllers;


import org.soulcodeacademy.helpr.domain.FuturoCliente;
import org.soulcodeacademy.helpr.domain.dto.FuturoClienteDTO;
import org.soulcodeacademy.helpr.services.FuturoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FuturoClienteController {

    @Autowired
    private FuturoClienteService futuroClienteService;


    @GetMapping("/clientes/futuros")
    public List<FuturoCliente> listar(){
        return this.futuroClienteService.listar();
    }

    @GetMapping("/clientes/futuros/{idFuturoCliente}")
    public FuturoCliente getFuturoClienteById(@PathVariable Integer idFuturoCliente){
        return this.futuroClienteService.getFuturoClienteById(idFuturoCliente);
    }

    //LISTAR POR EMAIL
    @GetMapping("/clientes/futuros/email")
    public List<FuturoCliente> listarPorEmail(@RequestParam String email){
        return this.futuroClienteService.listarPorEmail(email);
    }

    //Listar POR CPF
    @GetMapping("/clientes/futuros/cpf")
    public List<FuturoCliente> listarPorCpf(@RequestParam String cpf){
        return this.futuroClienteService.listarPorCpf(cpf);
    }

    @PostMapping("/clientes/futuros")
    public ResponseEntity<FuturoCliente> salvar(@Valid @RequestBody FuturoClienteDTO dto){
        FuturoCliente futuroCliente = this.futuroClienteService.salvar(dto);
        return new ResponseEntity<>(futuroCliente, HttpStatus.CREATED);
    }

    @PutMapping("/clientes/futuros/{idFuturoCliente}")
    public FuturoCliente atualizar(@PathVariable Integer idFuturoCliente, @Valid @RequestBody FuturoClienteDTO dto){
        FuturoCliente futuroClienteAtualizado = this.futuroClienteService.atualizar(idFuturoCliente, dto);
        return futuroClienteAtualizado;
    }

    @DeleteMapping("/clientes/futuros/{idFuturoCliente}")
    public ResponseEntity<Void> deletar(@PathVariable Integer idFuturoCliente){

        this.futuroClienteService.deletar((idFuturoCliente));
        return ResponseEntity.noContent().build();
    }
}