package com.campeonato.futebol.Model;


import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_champ;
    @Column
    private Date dataInicio;
    @Column
    private Date dataFim;

    private String time;





}
