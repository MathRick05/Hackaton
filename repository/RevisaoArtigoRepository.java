package com.example.hackaton.repository;

import com.example.hackaton.model.RevisaoArtigo;
import com.example.hackaton.model.RevisaoArtigo.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RevisaoArtigoRepository extends JpaRepository<RevisaoArtigo, Integer> {
    Optional<RevisaoArtigo> findFirstByArtigoIdAndTipo(Long artigoId, Tipo tipo);
}
