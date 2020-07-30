package com.sg.lanchessg.Model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@Data
public class Lanches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;
    @Column
    private BigDecimal Valor;
    @Column
    private int qntLanches;
//    private RetirarIngsEstoque(){
//        return Ingredientes;  //aqui vou ter de fazer conexão com o banco de dados
//                                 e alterar a tabela de estoque...de alguma forma
//    }

}
