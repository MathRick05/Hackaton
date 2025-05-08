package com.example.hackaton.Controller;

import com.example.hackaton.model.Evento;
import com.example.hackaton.Service.EventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping
    public ResponseEntity<Evento> criar(@RequestBody Evento evento) {
        return ResponseEntity.ok(eventoService.criar(evento));
    }

    @PutMapping
    public ResponseEntity<Evento> atualizar(@RequestBody Evento evento) {
        return ResponseEntity.ok(eventoService.atualizar(evento));
    }

    @GetMapping
    public ResponseEntity<List<Evento>> listar() {
        return ResponseEntity.ok(eventoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(eventoService.buscarPorId(id));
    }
}
