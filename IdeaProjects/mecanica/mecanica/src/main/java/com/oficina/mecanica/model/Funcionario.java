package com.oficina.mecanica.model;

import com.oficina.mecanica.model.enums.Ocupacao;
import com.oficina.mecanica.model.ids.Ids;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table
@Data
public class Funcionario extends Ids {
    @Column
    private String nome_funcionario;
    @Column
    private Ocupacao ocupacao;

}
