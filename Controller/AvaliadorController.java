package com.example.hackaton.Controller;

import com.example.hackaton.Service.AvaliadorService;
import com.example.hackaton.model.Avaliador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliadores")
public class AvaliadorController {

    private final AvaliadorService avaliadorService;

    public AvaliadorController(AvaliadorService avaliadorService) {
        this.avaliadorService = avaliadorService;
    }

    @PostMapping
    public ResponseEntity<Avaliador> criar(@RequestBody Avaliador avaliador) {
        return ResponseEntity.ok(avaliadorService.CriaAvaliador(avaliador));
    }

    @PutMapping
    public ResponseEntity<Avaliador> atualizar(@RequestBody Avaliador avaliador) {
        return ResponseEntity.ok(avaliadorService.atualizarAvaliador(avaliador));
    }
}