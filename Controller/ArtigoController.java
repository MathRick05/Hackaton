// Hackaton-main/Back/src/main/java/com/example/hackaton/Entity/Artigo.java
package com.example.hackaton.Controller;

import com.example.hackaton.Service.ArtigoService;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;

@Controller
public class ArtigoController {

    private final ArtigoService artigoService;

    public ArtigoController(ArtigoService artigoService) {
        this.artigoService = artigoService;
    }
    @GetMapping("/anonimo/{id}")
    public ResponseEntity<ArtigoAnonimoDTO> visualizarAnonimo(@PathVariable Long id) {
        return ResponseEntity.ok(artigoService.getArtigoAnonimo(id));
    }

}
