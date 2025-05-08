package com.example.hackaton.model;

import jakarta.persistence.*;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "artigo_id")
    private Artigo artigo;

    @ManyToOne
    @JoinColumn(name = "avaliador_id")
    private Avaliador avaliador;

    @Column(name = "nota")
    private double nota;

    @Column(name = "parecer")
    private String parecer;

    @Column(name = "comentarioAutor")
    private String comentarioAutor;

    @Column(name = "comentarioCoordenador")
    private String comentarioCoordenador;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo")
    private Metodo metodo;

    @Enumerated(EnumType.STRING)
    @Column(name = "recomendacao")
    private Recomendacao recomendacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    // Getters and Setters

    public enum Metodo {
        DoubleBlind,
    }

    public enum Recomendacao {
        Aprovar,
        Revisar,
        Rejeitar
    }

    public enum Status {
        EmAvaliacao,
        RevisaoSolicitada,
        Aprovado,
        Rejeitado
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

    public Avaliador getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Avaliador avaliador) {
        this.avaliador = avaliador;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getParecer() {
        return parecer;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
    }

    public String getComentarioAutor() {
        return comentarioAutor;
    }

    public void setComentarioAutor(String comentarioAutor) {
        this.comentarioAutor = comentarioAutor;
    }

    public String getComentarioCoordenador() {
        return comentarioCoordenador;
    }

    public void setComentarioCoordenador(String comentarioCoordenador) {
        this.comentarioCoordenador = comentarioCoordenador;
    }

    public Metodo getMetodo() {
        return metodo;
    }

    public void setMetodo(Metodo metodo) {
        this.metodo = metodo;
    }

    public Recomendacao getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(Recomendacao recomendacao) {
        this.recomendacao = recomendacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}

