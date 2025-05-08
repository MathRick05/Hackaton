package com.example.hackaton.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 1000)
    private String descricao;

    @Column
    private String bannerUrl;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFim;

    @Column(nullable = false)
    private LocalDate prazoSubmissaoInicial;

    @Column(nullable = false)
    private LocalDate prazoAvaliacao;

    @Column(nullable = false)
    private LocalDate prazoSubmissaoFinal;

    @Column
    private String local;

    @ManyToOne
    @JoinColumn(name = "coordenador_id")
    private Coordenador organizador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public LocalDate getPrazoSubmissaoInicial() {
        return prazoSubmissaoInicial;
    }

    public void setPrazoSubmissaoInicial(LocalDate prazoSubmissaoInicial) {
        this.prazoSubmissaoInicial = prazoSubmissaoInicial;
    }

    public LocalDate getPrazoAvaliacao() {
        return prazoAvaliacao;
    }

    public void setPrazoAvaliacao(LocalDate prazoAvaliacao) {
        this.prazoAvaliacao = prazoAvaliacao;
    }

    public LocalDate getPrazoSubmissaoFinal() {
        return prazoSubmissaoFinal;
    }

    public void setPrazoSubmissaoFinal(LocalDate prazoSubmissaoFinal) {
        this.prazoSubmissaoFinal = prazoSubmissaoFinal;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Coordenador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Coordenador organizador) {
        this.organizador = organizador;
    }


}



