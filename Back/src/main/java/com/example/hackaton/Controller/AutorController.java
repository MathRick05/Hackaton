package com.example.hackaton.Controller;

import com.example.hackaton.Service.AutorService;
import com.example.hackaton.model.Autor;
import com.example.hackaton.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    @Autowired
    private AutorRepository autorRepository;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<Autor> criarAutor(@RequestBody Autor autor) {
        Autor novoAutor = autorService.CriarAutor(autor);
        return ResponseEntity.ok(novoAutor);
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listarTodos() {
        return ResponseEntity.ok(autorRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable Long id) {
        Optional<Autor> autor = autorRepository.findById(id);
        return autor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> atualizarAutor(@PathVariable Long id, @RequestBody Autor autorAtualizado) {
        Optional<Autor> autorExistente = autorRepository.findById(id);
        if (autorExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Autor autor = autorExistente.get();
        autor.setNome(autorAtualizado.getNome());
        autor.setUsuario(autorAtualizado.getUsuario());
        autor.setEmail(autorAtualizado.getEmail());
        autor.setTelefone(autorAtualizado.getTelefone());
        autor.setSenhaHash(autorAtualizado.getSenhaHash());
        autor.setFiliacao(autorAtualizado.getFiliacao());
        autor.setAreaAtuacao(autorAtualizado.getAreaAtuacao());

        return ResponseEntity.ok(autorRepository.save(autor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAutor(@PathVariable Long id) {
        Optional<Autor> autorExistente = autorRepository.findById(id);
        if (autorExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        autorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}