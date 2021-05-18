package com.br.zupacademy.hugo.transacao.transacao.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cartao {
    @Id
    private String id;
    private String email;

    public Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    @Deprecated
    public Cartao() {
    }
}
