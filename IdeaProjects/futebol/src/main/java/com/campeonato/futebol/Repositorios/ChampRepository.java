package com.campeonato.futebol.Repositorios;

import com.campeonato.futebol.Model.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampRepository extends JpaRepository<Campeonato, Integer> {
}
