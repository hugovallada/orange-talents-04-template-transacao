package com.br.zupacademy.hugo.transacao.transacao;

import com.br.zupacademy.hugo.transacao.transacao.evento.EventoDeTransacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListenerDeTransacao {

    private final TransacoRepository transacaoRepository;

    private final Logger LOG = LoggerFactory.getLogger(ListenerDeTransacao.class);

    public ListenerDeTransacao(TransacoRepository transacaoRepository){
        this.transacaoRepository = transacaoRepository;
    }


    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao eventoDeTransacao){
        Transacao transacao = eventoDeTransacao.toModel();
        transacaoRepository.save(transacao);
        LOG.info("Transação de id " + eventoDeTransacao.getId()+ " persistida no banco");
    }


}
