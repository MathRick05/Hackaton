package com.example.hackaton.model;

import jakarta.persistence.*;

import java.util.List;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "artigos")
public class Artigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 1000)
    private String resumo;

    @ElementCollection
    @CollectionTable(name = "palavras_chave", joinColumns = @JoinColumn(name = "artigo_id"))
    @Column(name = "palavra")
    private List<String> palavrasChave;

    @Column(nullable = false)
    private String areaTematica;

    @Column(nullable = false)
    private String arquivoInicial;

    @Column
    private String arquivoFinal;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusArtigo status;

    public enum StatusArtigo {
        EM_AVALIACAO,
        REVISAO_SOLICITADA,
        APROVADO,
        REJEITADO
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public List<String> getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(List<String> palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public String getAreaTematica() {
        return areaTematica;
    }

    public void setAreaTematica(String areaTematica) {
        this.areaTematica = areaTematica;
    }

    public String getArquivoInicial() {
        return arquivoInicial;
    }

    public void setArquivoInicial(String arquivoInicial) {
        this.arquivoInicial = arquivoInicial;
    }

    public String getArquivoFinal() {
        return arquivoFinal;
    }

    public void setArquivoFinal(String arquivoFinal) {
        this.arquivoFinal = arquivoFinal;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public StatusArtigo getStatus() {
        return status;
    }

    public void setStatus(StatusArtigo status) {
        this.status = status;
    }


}


