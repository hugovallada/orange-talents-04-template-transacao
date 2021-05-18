package com.br.zupacademy.hugo.transacao.transacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacoRepository extends JpaRepository<Transacao, String> {
}
