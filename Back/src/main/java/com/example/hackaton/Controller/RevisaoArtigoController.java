package com.example.hackaton.Controller;

import com.example.hackaton.model.RevisaoArtigo;
import com.example.hackaton.Service.RevisaoArtigoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/revisoes")
public class RevisaoArtigoController {

    private final RevisaoArtigoService revisaoService;

    public RevisaoArtigoController(RevisaoArtigoService revisaoService) {
        this.revisaoService = revisaoService;
    }

    @PostMapping
    public ResponseEntity<RevisaoArtigo> enviar(@RequestBody RevisaoArtigo revisao) {
        return ResponseEntity.ok(revisaoService.enviarRevisao(revisao));
    }
}
