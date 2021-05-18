package com.br.zupacademy.hugo.transacao.config.stream;

import com.br.zupacademy.hugo.transacao.transacao.evento.EventoDeTransacao;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

// Classe de configuração do kafka
@Configuration
public class KafkaConfiguration {

    private final KafkaProperties kafkaProperties;

    public KafkaConfiguration(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    // Seta as properties do consumer
    public Map<String, Object> consumerConfiguration(){
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaProperties.getBootstrapServers());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getConsumer().getKeyDeserializer());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getConsumer().getValueDeserializer());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getConsumer().getGroupId());
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaProperties.getConsumer().getAutoOffsetReset());

        return properties;
    }


    /**
     * Função responsável por configurar um consumidor
     *
     */
    @Bean
    public ConsumerFactory<String, EventoDeTransacao> transacaoConsumerFactory(){
        var stringDeserializer = new StringDeserializer();
        var jsonDeserializer = new JsonDeserializer<>(EventoDeTransacao.class, false);

        return new DefaultKafkaConsumerFactory<>(consumerConfiguration(), stringDeserializer, jsonDeserializer);
    }

    /**
     * Cadastra o consumidor em um listener
     *
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, EventoDeTransacao> kafkaListenerContainerFactory(){
        var factory = new ConcurrentKafkaListenerContainerFactory<String, EventoDeTransacao>();
        factory.setConsumerFactory(transacaoConsumerFactory());

        return factory;
    }
}
