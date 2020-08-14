package com.oficina.mecanica.model;


import lombok.Data;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Cliente {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nome;
    @Column
    private String telefone;
}
