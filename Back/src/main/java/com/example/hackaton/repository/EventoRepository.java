package com.example.hackaton.repository;

import com.example.hackaton.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    // Métodos customizados caso queira viado
}
