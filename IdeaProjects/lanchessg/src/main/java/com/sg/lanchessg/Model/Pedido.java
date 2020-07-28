package com.sg.lanchessg.Model;

import javax.persistence.OneToMany;

public class Pedido {
    private int id;
    @OneToMany
    private String cliente;
    private double valortotal;


}
