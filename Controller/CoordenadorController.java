package com.example.hackaton.Controller;

import com.example.hackaton.Service.CoordenadorService;
import com.example.hackaton.model.Coordenador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coordenadores")
public class CoordenadorController {

    private final CoordenadorService coordenadorService;

    public CoordenadorController(CoordenadorService coordenadorService) {
        this.coordenadorService = coordenadorService;
    }

    @PostMapping
    public ResponseEntity<Coordenador> criar(@RequestBody Coordenador coordenador) {
        return ResponseEntity.ok(coordenadorService.criar(coordenador));
    }

    @PutMapping
    public ResponseEntity<Coordenador> atualizar(@RequestBody Coordenador coordenador) {
        return ResponseEntity.ok(coordenadorService.atualizar(coordenador));
    }
}
