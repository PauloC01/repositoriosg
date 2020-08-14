package com.oficina.mecanica.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table
@Data
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String placa;
    @Column
    private String cor;
    @Column
    private String modelo;
    @Column
    private String marca;
    @Column
    private String ano;
    @ManyToOne
    @JoinColumn
    private Cliente cliente;

}
