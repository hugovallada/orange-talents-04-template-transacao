package com.br.zupacademy.hugo.transacao.transacao;

import com.br.zupacademy.hugo.transacao.transacao.cartao.Cartao;
import com.br.zupacademy.hugo.transacao.transacao.estabelecimento.Estabelecimento;
import com.br.zupacademy.hugo.transacao.transacao.estabelecimento.EstabelecimentoResponse;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private String id;

    private BigDecimal valor;

    private EstabelecimentoResponse estabelecimento;

    private LocalDateTime efetivadaEm;

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
