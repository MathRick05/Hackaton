package com.example.hackaton.Cadastro_Evento.Controller;

import com.example.hackaton.Service.ArtigoService;
import com.example.hackaton.model.Artigo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/submissoes")
public class SubmissaoInicialController {

    private final ArtigoService artigoService;

    public SubmissaoInicialController(ArtigoService artigoService) {
        this.artigoService = artigoService;
    }

    @PostMapping("/inicial")
    public ResponseEntity<Artigo> submeterInicial(@RequestBody Artigo artigo) {
        return ResponseEntity.ok(artigoService.criarArtigo(artigo));
    }
}