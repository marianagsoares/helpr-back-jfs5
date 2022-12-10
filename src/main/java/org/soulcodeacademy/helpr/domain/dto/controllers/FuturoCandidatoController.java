package org.soulcodeacademy.helpr.domain.dto.controllers;


import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.FuturoCandidatoDTO;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.services.FuturoCandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.PublicKey;
import java.util.List;



@RestController
public class FuturoCandidatoController {
    @Autowired
    FuturoCandidatoService futuroCandidatoService;

    // listar todos
    @GetMapping("/candidatos")
    public List<FuturoCandidato> listar() {
        return this.futuroCandidatoService.listar();
    }

    // listar um

    @GetMapping("/candidatos/{idCandidato}")
    public FuturoCandidato getCandidato(@PathVariable Integer idCandidato) {
        return this.futuroCandidatoService.getCandidato(idCandidato);
    }

    //Filtrar pelo setor
    @GetMapping("candidatos/setor")
    public List<FuturoCandidato> listarPeloSetor(@RequestParam Setor setor){
        return this.futuroCandidatoService.listarPeloSetor(setor);
    }


    //Filtrar por email
    @GetMapping("candidatos/email")
    public List<FuturoCandidato> listarPorEmail(@RequestParam String email){
        return this.futuroCandidatoService.listarPorEmail(email);
    }

    //Filtra por nome
    @GetMapping("/candidatos/nome")
    public List<FuturoCandidato> listarPorFaixaSalarial(@RequestParam String nome) {
        return this.futuroCandidatoService.listarPorNome(nome);

    }

    // Salvar
    @PostMapping("/candidatos")
    public ResponseEntity<FuturoCandidato> salvar (@Valid @RequestBody FuturoCandidatoDTO dto){
        FuturoCandidato candidato = this.futuroCandidatoService.salvar(dto);
        return new ResponseEntity<>(candidato, HttpStatus.CREATED);
    }

    // deletar
    @DeleteMapping("/candidatos/{idCandidato}")
    public ResponseEntity<Void> deletar(@PathVariable Integer idCandidato){

        this.futuroCandidatoService.deletar(idCandidato);
        return ResponseEntity.noContent().build();

    }



}

