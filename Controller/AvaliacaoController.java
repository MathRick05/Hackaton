package com.example.hackaton.Controller;

import com.example.hackaton.model.Avaliacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
    
    private final com.example.hackaton.service.AvaliacaoService avaliacaoService;
    @Autowired
    public AvaliacaoController(com.example.hackaton.service.AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @PostMapping
    public ResponseEntity<Avaliacao> avaliar(@RequestBody Avaliacao avaliacao) {
        return ResponseEntity.ok(avaliacaoService.avaliar(avaliacao));
    }
}