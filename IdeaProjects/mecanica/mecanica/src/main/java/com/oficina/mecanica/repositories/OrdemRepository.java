package com.oficina.mecanica.repositories;

import com.oficina.mecanica.model.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Integer> {
}
