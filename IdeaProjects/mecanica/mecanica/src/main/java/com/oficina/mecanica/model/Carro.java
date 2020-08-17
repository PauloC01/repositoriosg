package com.oficina.mecanica.model;

import com.oficina.mecanica.model.ids.Ids;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table
@Data
public class Carro extends Ids {
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
