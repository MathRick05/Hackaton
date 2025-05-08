package com.example.hackaton.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "historicos")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
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


}
