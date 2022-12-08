package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.FuturoCliente;
import org.soulcodeacademy.helpr.domain.dto.FuturoClienteDTO;
import org.soulcodeacademy.helpr.repositories.FuturoClienteRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuturoClienteService {

    @Autowired
    FuturoClienteRepository futuroClienteRepository;

    public List<FuturoCliente> listar(){
        return this.futuroClienteRepository.findAll();
    }

    public FuturoCliente getFuturoClienteById(Integer idFuturoCandidato){
        return this.futuroClienteRepository.findById(idFuturoCandidato)
                .orElseThrow(() -> new RecursoNaoEncontradoError("Futuro cliente não encontrado"));
    }

    //LISTAR POR EMAIL FUTURO CLIENTE
    public List<FuturoCliente> listarPorEmail(String emailFuturoCliente){
        return this.futuroClienteRepository.findByEmail(emailFuturoCliente);
    }

    //LISTAR POR CPF FUTURO CLIENTE
    public List<FuturoCliente> listarPorCpf(String cpfFuturoCliente){
        return this.futuroClienteRepository.findByCpf(cpfFuturoCliente);
    }


    public FuturoCliente salvar(FuturoClienteDTO dto){
        FuturoCliente novofuturoCliente = new FuturoCliente(null, dto.getNome(), dto.getCpf(), dto.getEmail(), dto.getTelefone());

        return this.futuroClienteRepository.save(novofuturoCliente);
    }

    public FuturoCliente atualizar(Integer idFuturoCliente, FuturoClienteDTO dto){
        FuturoCliente futuroCliente = this.getFuturoClienteById(idFuturoCliente);

        futuroCliente.setNome(dto.getNome());
        futuroCliente.setCpf(dto.getCpf());
        futuroCliente.setEmail(dto.getEmail());
        futuroCliente.setTelefone(dto.getTelefone());

        return this.futuroClienteRepository.save(futuroCliente);
    }


    public void deletar(Integer idFuturoCliente) {

        FuturoCliente futuroCliente = this.getFuturoClienteById(idFuturoCliente);

            this.futuroClienteRepository.delete(futuroCliente);
     }
}
