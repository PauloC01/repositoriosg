package com.oficina.mecanica.model;


import com.oficina.mecanica.model.ids.Ids;
import lombok.Data;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Cliente extends Ids {
    @Column
    private String nome;
    @Column
    private String telefone;
}
