package com.example.hackaton.repository;

import com.example.hackaton.Controller.ArtigoController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepository extends JpaRepository<ArtigoController, Long> {
}