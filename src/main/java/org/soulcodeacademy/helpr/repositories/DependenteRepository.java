package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DependenteRepository extends JpaRepository <DependenteRepository, Integer> {

    @Query(value = "SELECT * FROM dependente WHERE dataDeNascimento BETWEEN :data1 AND :data2", nativeQuery = true)
    List<Chamado> buscarEntreDatas(LocalDate data1, LocalDate data2);
    Optional<DependenteRepository> findByeEscolaridade(String escolaridade);
    Optional<DependenteRepository> findByCpf(String cpf);

    @Override
    Optional<DependenteRepository> findById(Integer integer);
}
