package com.example.hackaton.repository;

import com.example.hackaton.model.Avaliador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvaliadorRepository extends JpaRepository<Avaliador, Long> {
    Optional<Avaliador> findByEmail(String email);
    Optional<Avaliador> findByUsuario(String usuario);
}
