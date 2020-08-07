package com.campeonato.futebol.Model;
 import lombok.Data;

 import javax.persistence.*;

@Entity
@Data
public class Colocacao {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_time")
    private Time time;
    @ManyToOne
    @JoinColumn(name = "id_champ")
    private Campeonato champ;
            private int gols;
            private int vitorias;
            private int derrotas;
            private int jogos;
            private int empates;
            private int pontos;

}