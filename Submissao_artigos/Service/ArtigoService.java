package com.example.hackaton.Submissao_artigos.Service;

import com.example.hackaton.Submissao_artigos.Controller.ArtigoController;
import com.example.hackaton.Submissao_artigos.repository.ArtigoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@Service
public class ArtigoService {

    private static final Logger logger = LoggerFactory.getLogger(ArtigoService.class);

    private final ArtigoRepository artigoRepository;
    private final StorageService storageService;

    @Autowired
    public ArtigoService(ArtigoRepository artigoRepository, StorageService storageService) {
        this.artigoRepository = artigoRepository;
        this.storageService = storageService;
    }

    @Transactional
    public ArtigoController Submissao(String titulo, String autores, String resumo,
                                      String palavrasChave, String areaTematica, MultipartFile arquivoPdf) {
        logger.info("Processando submissão do artigo: {}", titulo);

        // 1. Salvar o arquivo PDF
        String nomeArquivoSalvo = storageService.store(arquivoPdf);
        Path caminhoCompletoArquivo = storageService.load(nomeArquivoSalvo);

        // 2. Criar e salvar os metadados do artigo no banco
        ArtigoController novoArtigo = new ArtigoController();
        novoArtigo.setTitulo(titulo);
        novoArtigo.setAutores(autores);
        novoArtigo.setResumo(resumo);
        novoArtigo.setPalavrasChave(palavrasChave);
        novoArtigo.setAreaTematica(areaTematica);
        novoArtigo.setNomeArquivoPdf(StringUtils.cleanPath(arquivoPdf.getOriginalFilename())); // Nome original
        novoArtigo.setCaminhoArquivoPdf(caminhoCompletoArquivo.toString()); // Caminho completo ou relativo onde foi salvo

        // A data de submissão é definida automaticamente pelo @PrePersist na entidade Artigo

        ArtigoController artigoSalvo = artigoRepository.save(novoArtigo);
        logger.info("Artigo '{}' salvo com ID: {}", artigoSalvo.getTitulo(), artigoSalvo.getId());

        return artigoSalvo;
    }

    // Você pode adicionar outros métodos aqui, como buscarArtigoPorId, listarArtigos, etc.
}