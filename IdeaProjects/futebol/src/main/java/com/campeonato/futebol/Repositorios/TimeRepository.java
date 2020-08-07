package com.campeonato.futebol.Repositorios;

import com.campeonato.futebol.Model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {
}
