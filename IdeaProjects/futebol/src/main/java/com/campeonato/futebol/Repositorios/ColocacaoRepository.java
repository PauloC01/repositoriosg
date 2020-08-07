package com.campeonato.futebol.Repositorios;

import com.campeonato.futebol.Model.Colocacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColocacaoRepository extends JpaRepository<Colocacao, Integer> {
    Colocacao findByChampTime(int torneio, int time);
    List<Colocacao> findByTorneio(int torneio);
}
