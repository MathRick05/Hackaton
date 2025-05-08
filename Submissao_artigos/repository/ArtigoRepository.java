package com.example.hackaton.Submissao_artigos.repository;

import com.example.hackaton.Submissao_artigos.Controller.ArtigoController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepository extends JpaRepository<ArtigoController, Long> {
}