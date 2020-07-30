package com.sg.lanchessg.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn
    private Cliente id_Cliente;
    private Date data = new Date();
    @JoinColumn
    @OneToMany
    private List<Combo> combos;
    @Column
    private int qntCombos;
    @Column
    private double valortotal;
    @JoinColumn
    @OneToMany
    private List<Produtos> produtos;
    private int qntProdutos;


}
