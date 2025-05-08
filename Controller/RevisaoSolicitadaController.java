package com.example.hackaton.Cadastro_Evento.Controller;

import com.example.hackaton.Service.ArtigoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/artigos")
public class RevisaoSolicitadaController {

    private final ArtigoService artigoService;

    public RevisaoSolicitadaController(ArtigoService artigoService) {
        this.artigoService = artigoService;
    }

    @PutMapping("/solicitar-revisao/{id}")
    public ResponseEntity<?> solicitarRevisao(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(artigoService.solicitarRevisao(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}