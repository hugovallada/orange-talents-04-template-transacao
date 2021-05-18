package com.br.zupacademy.hugo.transacao.transacao.evento;

import com.br.zupacademy.hugo.transacao.transacao.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Representa os dados que chegam na stream
public class EventoDeTransacao {

    private String id;

    private BigDecimal valor;

    private EventoDeEstabelecimento estabelecimento;

    private EventoDeCartao cartao;

    private LocalDateTime efetivadaEm;

    @Override
    public String toString() {
        return "EventoDeTransacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EventoDeEstabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public EventoDeCartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toModel() {
        return new Transacao(id, valor, cartao.toModel(), estabelecimento.toModel(), efetivadaEm);
    }
}
