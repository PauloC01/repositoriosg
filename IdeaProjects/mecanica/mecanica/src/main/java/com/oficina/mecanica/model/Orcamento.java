package com.oficina.mecanica.model;

import com.oficina.mecanica.model.enums.StatusOrcamento;
import lombok.Data;
import javax.persistence.*;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
@Data
public class Orcamento  {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private BigDecimal preco_orcado;
    @Column
    private String descricao_servico;
    @ManyToOne
    @JoinColumn(name = "fk_mecanico")
    private Funcionario mecanico;
    @OneToOne
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;
    @Column
    private StatusOrcamento statusOrcamento;
    @Column
    private byte diasEstimados;
    @Column
    public LocalDate dataInicio;
}
