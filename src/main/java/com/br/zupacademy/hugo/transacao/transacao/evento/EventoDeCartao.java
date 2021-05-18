package com.br.zupacademy.hugo.transacao.transacao.evento;

import com.br.zupacademy.hugo.transacao.transacao.cartao.Cartao;

public class EventoDeCartao {

    private String id;
    private String email;

    @Override
    public String toString() {
        return "EventoDeCartao{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toModel(){
        return new Cartao(id, email);
    }
}
