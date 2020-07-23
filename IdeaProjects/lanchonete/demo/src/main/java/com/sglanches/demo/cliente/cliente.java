package com.sglanches.demo.cliente;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class cliente {//entidade
    private int id;
    private String nome;
    private String numeroTEL;
    private void AdicionarCliente(){

    }
}
