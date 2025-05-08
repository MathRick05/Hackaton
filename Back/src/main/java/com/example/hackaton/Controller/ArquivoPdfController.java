package com.example.hackaton.Controller;

import com.example.hackaton.model.ArquivoPdf;
import com.example.hackaton.Service.ArquivoPdfService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/arquivos")
public class ArquivoPdfController {

    private final ArquivoPdfService arquivoPdfService;

    public ArquivoPdfController(ArquivoPdfService arquivoPdfService) {
        this.arquivoPdfService = arquivoPdfService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadPdf(@RequestParam("file") MultipartFile file) {
        try {
            ArquivoPdf salvo = arquivoPdfService.salvarArquivo(file);
            return ResponseEntity.ok(salvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
