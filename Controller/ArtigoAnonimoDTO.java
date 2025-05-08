package com.example.hackaton.Controller;

import java.util.List;

public class ArtigoAnonimoDTO {

    private String titulo;
    private String resumo;
    private List<String> palavrasChave;
    private String arquivoInicial;


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

    public String getArquivoInicial() {
        return arquivoInicial;
    }

    public void setArquivoInicial(String arquivoInicial) {
        this.arquivoInicial = arquivoInicial;
    }
}
