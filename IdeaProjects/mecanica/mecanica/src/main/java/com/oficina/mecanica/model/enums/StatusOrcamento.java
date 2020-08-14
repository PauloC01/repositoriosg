package com.oficina.mecanica.model.enums;

import lombok.Getter;

@Getter
public enum StatusOrcamento {
    APROVADO(0), REJEITADO(1), EM_ANALISE(2);
    private int tipo;

    StatusOrcamento(int tipo){
        this.tipo = tipo;
    }

}
