package com.sg.lanchessg.Repositories;

import com.sg.lanchessg.Model.Cliente;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Integer>  {}
