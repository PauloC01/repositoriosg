package com.oficina.mecanica.model.ids;

import lombok.Getter;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public class Ids {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
