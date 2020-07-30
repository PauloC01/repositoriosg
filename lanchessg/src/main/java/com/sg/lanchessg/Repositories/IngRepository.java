package com.sg.lanchessg.Repositories;


import com.sg.lanchessg.Model.Ingredientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngRepository extends JpaRepository<Ingredientes, Integer> {
}
