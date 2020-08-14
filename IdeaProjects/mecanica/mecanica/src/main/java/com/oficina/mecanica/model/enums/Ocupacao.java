package com.oficina.mecanica.model.enums;

import lombok.Getter;

@Getter
public enum Ocupacao {
    OFICINA(0), ATENDENTE(1);
    private int ocupacao;

    Ocupacao(int tipo) {
        ocupacao = tipo;
    }
}
