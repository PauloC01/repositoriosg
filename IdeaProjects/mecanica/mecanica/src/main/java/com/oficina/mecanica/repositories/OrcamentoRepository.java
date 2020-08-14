package com.oficina.mecanica.repositories;

import com.oficina.mecanica.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer> {
}
