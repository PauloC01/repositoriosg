package com.sg.lanchessg.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
@Data
@Getter
@Setter
public class Combo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String nome;
    @Column
    private BigDecimal valorCombo;
    @Column
    private int quantidade;

    @JoinColumn
    @OneToMany         //junta os combos na tabela de produtos
    private List<Lanches> produtos;




}
