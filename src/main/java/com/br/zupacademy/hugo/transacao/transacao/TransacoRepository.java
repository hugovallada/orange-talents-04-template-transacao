package com.br.zupacademy.hugo.transacao.transacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacoRepository extends JpaRepository<Transacao, String> {

    Boolean existsByCartaoId(String cartaoId);

    List<Transacao> findFirst10ByCartaoIdOrderByEfetivadaEmDesc(String cartaoId);


}
