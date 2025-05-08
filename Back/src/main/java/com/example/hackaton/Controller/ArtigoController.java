// Hackaton-main/Back/src/main/java/com/example/hackaton/Entity/Artigo.java
package com.example.hackaton.Controller;

import com.example.hackaton.Service.ArtigoService;
import com.example.hackaton.model.Artigo;
import com.example.hackaton.repository.ArtigoRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/artigos")
public class ArtigoController {

    private final ArtigoService artigoService;

    @Autowired
    private ArtigoRepository artigoRepository;

    public ArtigoController(ArtigoService artigoService) {
        this.artigoService = artigoService;
    }
    @GetMapping("/anonimo/{id}")
    public ResponseEntity<ArtigoAnonimoDTO> visualizarAnonimo(@PathVariable Long id) {
        return ResponseEntity.ok(artigoService.getArtigoAnonimo(id));
    }
    @PostMapping
    public ResponseEntity<Artigo> criar(@RequestBody Artigo artigo) {
        Artigo novo = artigoService.criarArtigo(artigo);
        return ResponseEntity.ok(novo);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> atualizarStatus(@PathVariable Long id, @RequestBody Artigo artigo) {
        Optional<Artigo> artigoExistente = artigoRepository.findById(id);
        if (artigoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Artigo existente = artigoExistente.get();
        existente.setStatus(artigo.getStatus());
        artigoRepository.save(existente);

        return ResponseEntity.ok().build();
    }

}
