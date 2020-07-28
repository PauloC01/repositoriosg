package com.sg.lanchessg.Model;


import lombok.Data;


import javax.persistence.*;

@Entity
@Table
@Data
public class Cliente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column (nullable = false)
    private String nome;
@Column (nullable = false, length = 10)
    private String telefone;

}
