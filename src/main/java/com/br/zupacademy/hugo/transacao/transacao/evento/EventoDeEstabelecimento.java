package com.br.zupacademy.hugo.transacao.transacao.evento;

import com.br.zupacademy.hugo.transacao.transacao.estabelecimento.Estabelecimento;

public class EventoDeEstabelecimento {
    private String nome;
    private String cidade;
    private String endereco;



    @Override
    public String toString() {
        return "EventoDeEstabelecimento{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toModel(){
        return new Estabelecimento(nome, cidade, endereco);
    }
}
