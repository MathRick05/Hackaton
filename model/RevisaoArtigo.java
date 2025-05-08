package com.example.hackaton.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "revisaoartigo")
public class RevisaoArtigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "artigo_id")
    private Artigo artigo;

    @Column(name = "versao")
    private String versao;

    @Column(name = "arquivoPdf")
    private String arquivoPdf;

    @Column(name = "dataEnvio")
    private Date dataEnvio;

    @Column(name = "observacao")
    private String observacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private Tipo tipo;

    public enum Tipo {
        Inicial,
        Revisada
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Artigo getArtigo() {
        return artigo;
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getArquivoPdf() {
        return arquivoPdf;
    }

    public void setArquivoPdf(String arquivoPdf) {
        this.arquivoPdf = arquivoPdf;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}

