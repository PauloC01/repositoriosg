package com.sg.lanchessg.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table
public class Ingredientes {
    @Id
    private int id;
    @Column
    private String nome;
    @Column
    private BigDecimal massa;
    @Column
    private int quantidadeIng;
}
