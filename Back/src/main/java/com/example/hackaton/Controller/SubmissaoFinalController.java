package com.example.hackaton.Cadastro_Evento.Controller;

import com.example.hackaton.Service.RevisaoArtigoService;
import com.example.hackaton.model.RevisaoArtigo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/revisoes-finais")
public class SubmissaoFinalController {

    private final RevisaoArtigoService revisaoArtigoService;

    public SubmissaoFinalController(RevisaoArtigoService revisaoArtigoService) {
        this.revisaoArtigoService = revisaoArtigoService;
    }

    @PostMapping
    public ResponseEntity<?> enviarFinal(@RequestBody RevisaoArtigo revisao) {
        try {
            return ResponseEntity.ok(revisaoArtigoService.enviarRevisao(revisao));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
