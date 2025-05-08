package com.example.hackaton.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "historicos")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String arquivoUrl;

    @Column(nullable = false)
    private LocalDate dataGeracao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FormatoHistorico formato;

    public enum FormatoHistorico {
        PDF,
        HTML
    }

    @ManyToOne
    @JoinColumn(name = "artigo_id")
    private Artigo artigo;

    @Column
    private String descricao;

    @Column
    private LocalDate dataAcao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArquivoUrl() {
        return arquivoUrl;
    }

    public void setArquivoUrl(String arquivoUrl) {
        this.arquivoUrl = arquivoUrl;
    }

    public LocalDate getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDate dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public FormatoHistorico getFormato() {
        return formato;
    }

    public void setFormato(FormatoHistorico formato) {
        this.formato = formato;
    }

    public Artigo getArtigo() {
        return artigo;
    }
    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAcao() {
        return dataAcao;
    }
    public void setDataAcao(LocalDate dataAcao) {
        this.dataAcao = dataAcao;

    }
}