package com.sglanches.demo.repositorios;

import com.sglanches.demo.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Cliente, Integer>  {}
