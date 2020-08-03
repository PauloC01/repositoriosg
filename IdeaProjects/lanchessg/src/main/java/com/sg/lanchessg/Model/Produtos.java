package com.sg.lanchessg.Model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
@Data
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    @Column
    private BigDecimal preco;
    @Column
    private int qntProdutos;
            @JoinColumn
            @ManyToMany
            private List<Ingredientes> ingredientes;
            @JoinColumn
            @ManyToMany
            private List<Lanches> lanches;
}
