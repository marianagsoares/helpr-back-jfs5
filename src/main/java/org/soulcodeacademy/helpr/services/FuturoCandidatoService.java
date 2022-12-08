package org.soulcodeacademy.helpr.services;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.FuturoCandidatoDTO;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.repositories.FuturoCandidatoRepository;
import org.soulcodeacademy.helpr.services.errors.DataIntegrityViolationException;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class FuturoCandidatoService {

        @Autowired
        FuturoCandidatoRepository futuroCandidatoRepository;

        //Listar todos
        public List<FuturoCandidato>listar(){
            return this.futuroCandidatoRepository.findAll();
        }

        // Listar por ID
        public FuturoCandidato getCandidato(Integer idCandidato) {
            return  this.futuroCandidatoRepository.findById(idCandidato)
                    .orElseThrow(() -> new RecursoNaoEncontradoError("Futuro candidato não encontrado"));
        }


        //Filtrar pelo setor
        public List<FuturoCandidato>listarPeloSetor(Setor setor){
            return this.futuroCandidatoRepository.findBySetor(setor);
        }

        //Filtrar por Email
        public  List<FuturoCandidato>listarPorEmail(String email){
            return this.futuroCandidatoRepository.findByEmail(email);
        }


        // Filtrar por nome
        public List<FuturoCandidato> listarPorNome(String nome) {
            return this.futuroCandidatoRepository.findByNomeCompletoContaining(nome);
        }


        //Salvar Futuro Candidato
        public FuturoCandidato salvar (FuturoCandidatoDTO dto ){

            FuturoCandidato novoCandidato = new FuturoCandidato(null, dto.getNomeCompleto(), dto.getEmail(), dto.getDescricaoDasHabilidades());
            novoCandidato.setSetor(dto.getSetor());
            return  this.futuroCandidatoRepository.save(novoCandidato);
        }

        // Deletar Futuro Candidato
        public void deletar(Integer idFuncionario) {
            FuturoCandidato candidato = this.getCandidato(idFuncionario);
            try {
                this.futuroCandidatoRepository.delete(candidato);

            } catch (org.springframework.dao.DataIntegrityViolationException error){

                throw new DataIntegrityViolationException("Não foi possível continuar operação");
            }

        }

    }

