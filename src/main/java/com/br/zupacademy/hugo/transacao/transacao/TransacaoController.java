package com.br.zupacademy.hugo.transacao.transacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacoRepository transacoRepository;

    public TransacaoController(TransacoRepository transacoRepository) {
        this.transacoRepository = transacoRepository;
    }

    @GetMapping("/{idCartao}")
    public ResponseEntity<List<TransacaoResponse>> consultarPorCartao(@PathVariable String idCartao,
                                                                      @AuthenticationPrincipal Jwt auth){

        if(!transacoRepository.existsByCartaoId(idCartao)){
            return ResponseEntity.notFound().build();
        }

        var transacoes = transacoRepository.findFirst10ByCartaoIdOrderByEfetivadaEmDesc(idCartao);

        var response = transacoes.stream().map(TransacaoResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(response);
    }
}
