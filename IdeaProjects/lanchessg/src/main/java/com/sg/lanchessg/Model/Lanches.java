package com.sg.lanchessg.Model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
@Data
public class Lanches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;
    @Column
    private BigDecimal Valor;
    @Column
    private int qntLanches;
    @JoinColumn
    @OneToMany  //juntas os lanches à tabela de produtos
    private List<Produtos> produtos;
    @JoinColumn
    @ManyToMany
    private List<Ingredientes> ingredientes;

}
