package com.campeonato.futebol.Repositorios;

import com.campeonato.futebol.Model.Jogos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogos, Integer> {
}
