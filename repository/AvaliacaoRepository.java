package com.example.hackaton.repository;

import com.example.hackaton.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
    Optional<Avaliacao> findByArtigoIdAndAvaliadorId(Long artigoId, Long avaliadorId);
}
