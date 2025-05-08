package com.example.hackaton.Controller;

import com.example.hackaton.Service.AvaliacaoService;
import com.example.hackaton.model.Avaliacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    @Autowired
    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @PostMapping
    public ResponseEntity<Avaliacao> avaliar(@RequestBody Avaliacao avaliacao) {
        return ResponseEntity.ok(avaliacaoService.avaliar(avaliacao));
    }

    @GetMapping
    public ResponseEntity<List<Avaliacao>> listarTodas() {
        return ResponseEntity.ok(avaliacaoService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> buscarPorId(@PathVariable int id) {
        Avaliacao avaliacao = avaliacaoService.buscarPorId(id);
        if (avaliacao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(avaliacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avaliacao> atualizar(@PathVariable int id, @RequestBody Avaliacao avaliacaoAtualizada) {
        Avaliacao atualizada = avaliacaoService.atualizar(id, avaliacaoAtualizada);
        if (atualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        boolean removido = avaliacaoService.deletar(id);
        if (!removido) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
