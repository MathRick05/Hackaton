// Hackaton-main/Back/src/main/java/com/example/hackaton/Entity/Artigo.java
package com.example.hackaton.Submissao_artigos.Controller;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class ArtigoController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    @NotBlank(message = "Autores são obrigatórios")
    private String autores;

    @NotBlank(message = "Resumo é obrigatório")
    @Column(length = 2000)
    private String resumo;

    @NotBlank(message = "Palavras-chave são obrigatórias")
    private String palavrasChave;

    @NotBlank(message = "Área temática é obrigatória")
    private String areaTematica;

    // --- Correção/Consistência de Nomes ---
    @Column(name = "nome_arquivo_pdf") // Mapeando para nome da coluna se diferente
    private String nomeArquivoPdf; // Renomeado para consistência com Service

    @Column(name = "caminho_arquivo_pdf") // Mapeando para nome da coluna se diferente
    private String caminhoArquivoPdf; // Renomeado para consistência com Service
    // --- Fim Correção ---

    @Column(name = "data_submissao", nullable = false, updatable = false)
    private LocalDateTime dataSubmissao;

    @PrePersist
    protected void onCreate() {
        this.dataSubmissao = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutores() { return autores; }
    public void setAutores(String autores) { this.autores = autores; }

    public String getResumo() { return resumo; }
    public void setResumo(String resumo) { this.resumo = resumo; }

    public String getPalavrasChave() { return palavrasChave; }
    public void setPalavrasChave(String palavrasChave) { this.palavrasChave = palavrasChave; }

    public String getAreaTematica() { return areaTematica; }
    public void setAreaTematica(String areaTematica) { this.areaTematica = areaTematica; }

    public String getNomeArquivoPdf() { return nomeArquivoPdf; }
    public void setNomeArquivoPdf(String nomeArquivoPdf) { this.nomeArquivoPdf = nomeArquivoPdf; }

    public String getCaminhoArquivoPdf() { return caminhoArquivoPdf; }
    public void setCaminhoArquivoPdf(String caminhoArquivoPdf) { this.caminhoArquivoPdf = caminhoArquivoPdf; }

    public LocalDateTime getDataSubmissao() { return dataSubmissao; }
    public void setDataSubmissao(LocalDateTime dataSubmissao) { this.dataSubmissao = dataSubmissao; }
    // --- FIM GETTERS E SETTERS ---
}