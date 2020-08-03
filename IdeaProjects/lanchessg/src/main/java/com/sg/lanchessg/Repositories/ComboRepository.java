package com.sg.lanchessg.Repositories;

import com.sg.lanchessg.Model.Combo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboRepository extends JpaRepository<Combo, Integer> {


}
