package com.campeonato.futebol.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Jogos {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id_jogo;
  @ManyToOne
  @JoinColumn(name = "id_champ")
  private Campeonato campeonato;
  private String data;
  @ManyToOne
  @JoinColumn
    private Time visitante;
    private int gols_visitante = 0;
  @ManyToOne
  @JoinColumn
    private Time daCasa;
    private int gols_daCasa = 0;


}
