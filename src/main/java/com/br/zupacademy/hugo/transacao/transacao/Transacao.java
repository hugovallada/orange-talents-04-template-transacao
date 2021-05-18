package com.br.zupacademy.hugo.transacao.transacao;

import com.br.zupacademy.hugo.transacao.transacao.cartao.Cartao;
import com.br.zupacademy.hugo.transacao.transacao.estabelecimento.Estabelecimento;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    private String id;

    private BigDecimal valor;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Estabelecimento estabelecimento;

    private LocalDateTime efetivadaEm;

    public Transacao(String id, BigDecimal valor, Cartao cartao, Estabelecimento estabelecimento, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.cartao = cartao;
        this.estabelecimento = estabelecimento;
        this.efetivadaEm = efetivadaEm;
    }

    @Deprecated
    public Transacao() {
    }
}
