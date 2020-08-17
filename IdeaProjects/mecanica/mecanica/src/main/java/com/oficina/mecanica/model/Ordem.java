package com.oficina.mecanica.model;

import com.oficina.mecanica.model.ids.Ids;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Data
public class Ordem extends Ids {
    @OneToOne
    @JoinColumn
    private Orcamento orcamento;
    @Column
    private LocalDate dataTemino;
    @Column
    private byte diasTrabalhados;
}
