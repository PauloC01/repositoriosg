package com.sglanches.demo.entidades;


import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Cliente {
@Id
    private int id;
    private String nome;
    private String telefone;

}
