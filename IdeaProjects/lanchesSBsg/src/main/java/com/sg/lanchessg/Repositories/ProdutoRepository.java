package com.sg.lanchessg.Repositories;


import com.sg.lanchessg.Model.Produtos;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Integer> {
}
