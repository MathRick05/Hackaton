package com.example.hackaton.repository;

import com.example.hackaton.model.Coordenador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoordenadorRepository extends JpaRepository<Coordenador, Long> {
    Optional<Coordenador> findByUsuario(String usuario);
}
