package com.example.hackaton.repository;

import com.example.hackaton.Controller.ArtigoAnonimoDTO;
import com.example.hackaton.Controller.ArtigoController;
import com.example.hackaton.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
    @Query("SELECT new com.example.hackaton.Controller.ArtigoAnonimoDTO(a.titulo, a.resumo, a.palavrasChave, a.arquivoInicial) " +
            "FROM Artigo a WHERE a.id = :id")
    static ArtigoAnonimoDTO findArtigoAnonimoById(Long id);

}