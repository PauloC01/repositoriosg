package com.sglanches.demo.produto;

import javax.persistence.Id;

public class Lanches {
    @Id
    private  int id;
    protected String nome;
    private int QuantidadeLanches;
    private double valor;
    private void subtrairEstoque(){

    }
}
