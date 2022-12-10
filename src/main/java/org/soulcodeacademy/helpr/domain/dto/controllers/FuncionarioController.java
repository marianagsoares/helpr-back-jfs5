package org.soulcodeacademy.helpr.domain.dto.controllers;

import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // esta classe é capaz de captar as requisições
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    // /funcionarios (GET)
    @GetMapping("/funcionarios")
    public List<Funcionario> listar() {
        return this.funcionarioService.listar();
    }

    // @RequestParam = Captura os valores de parâmetro após ?, ex: /funcionarios/salario?valor1=1000&valor2=2000
    @GetMapping("/funcionarios/salario")
    public List<Funcionario> listarPorFaixaSalarial(@RequestParam Double valor1, @RequestParam Double valor2) {
        return this.funcionarioService.listarPorFaixaSalarial(valor1, valor2);
    }

    // /funcionarios/{id} (GET)
    @GetMapping("/funcionarios/{idFuncionario}")
    public Funcionario getFuncionario(@PathVariable Integer idFuncionario) {
        return this.funcionarioService.getFuncionario(idFuncionario);
    }

    // POST = Representa inserção de dados
    @PostMapping("/funcionarios")
    public ResponseEntity<Funcionario> salvar(@Valid @RequestBody FuncionarioDTO dto) {
        Funcionario funcionario = this.funcionarioService.salvar(dto);
        return new ResponseEntity<>(funcionario, HttpStatus.CREATED);
    }

    // PUT = Representa substituição de dados
    @PutMapping("/funcionarios/{idFuncionario}")
    public Funcionario atualizar(@PathVariable Integer idFuncionario, @Valid @RequestBody FuncionarioDTO dto) {
        Funcionario atualizado = this.funcionarioService.atualizar(idFuncionario, dto);
        return atualizado;
    }

    @DeleteMapping("/funcionarios/{idFuncionario}")
    public ResponseEntity<Void> deletar(@PathVariable Integer idFuncionario) {

        this.funcionarioService.deletar(idFuncionario);
        return ResponseEntity.noContent().build();
    }
}
