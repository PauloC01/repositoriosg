package com.oficina.mecanica.model;

import com.oficina.mecanica.model.enums.Ocupacao;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table
@Data
public class Funcionario  {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nome_funcionario;
    @Column
    private Ocupacao ocupacao;

}
