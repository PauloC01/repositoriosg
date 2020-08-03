package com.sg.lanchessg.Repositories;


import com.sg.lanchessg.Model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
