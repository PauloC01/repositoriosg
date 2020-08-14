package com.oficina.mecanica.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
@Data
public class Ordem {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    @JoinColumn
    private Orcamento orcamento;
    @Column
    private LocalDate dataTemino;
    @Column
    private LocalDate dataEntrega;
}
