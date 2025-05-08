package com.example.hackaton.Controller;

import com.example.hackaton.model.Historico;
import com.example.hackaton.Service.HistoricoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/historicos")
public class HistoricoController {

    private final HistoricoService historicoService;

    public HistoricoController(HistoricoService historicoService) {
        this.historicoService = historicoService;
    }

    @PostMapping
    public ResponseEntity<?> gerarHistorico(@RequestBody Historico historico) {
        try {
            Historico criado = historicoService.gerarHistorico(historico);
            return ResponseEntity.ok(criado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/por-evento/{eventoId}")
    public ResponseEntity<?> buscarPorEvento(@PathVariable Long eventoId) {
        return historicoService.buscarPorEventoId(eventoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}