package com.campeonato.futebol.Model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table
@Data
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_time;
    @Column
    private String nome_time;
    @Column
    private String cidade_time;
    @Column
    private int pontos;



}
