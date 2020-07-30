package com.sg.lanchessg.Repositories;

import com.sg.lanchessg.Model.Lanches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LancheRepository extends JpaRepository<Lanches, Integer> {

}
