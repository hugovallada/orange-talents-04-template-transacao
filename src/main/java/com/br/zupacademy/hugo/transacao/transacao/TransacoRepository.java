package com.br.zupacademy.hugo.transacao.transacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacoRepository extends JpaRepository<Transacao, String> {

    Boolean existsByCartaoId(String cartaoId);

    Boolean existsByCartaoIdAndCartaoEmail(String cartaoId, String email);

    List<Transacao> findFirst10ByCartaoIdOrderByEfetivadaEmDesc(String cartaoId);


}
