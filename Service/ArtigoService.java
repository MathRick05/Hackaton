package com.example.hackaton.Service;

import com.example.hackaton.Controller.ArtigoAnonimoDTO;
import com.example.hackaton.model.Artigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hackaton.repository.ArtigoRepository;

@Service
public class ArtigoService {
    private final ArtigoRepository artigoRepository;

    @Autowired
    public ArtigoService(ArtigoRepository artigoRepository) {
        this.artigoRepository = artigoRepository;
    }
    public Artigo criarArtigo(Artigo artigo) {
        validarCriacao(artigo); // Validação de regras de negócio
        return artigoRepository.save(artigo); // Persistência no banco de dados
    }

    public void validarCriacao(Artigo artigo) {
        if(artigo.getPalavrasChave() == null || artigo.getPalavrasChave().size() < 2){
            throw new IllegalArgumentException("O artigo tem menos que 2 palavras chaves");
        }
        artigo.setStatus(Artigo.StatusArtigo.EM_AVALIACAO);
    }

    public void validarAtualizacao(Artigo artigoExistente, Artigo novosDados) {
        if(artigoExistente.getStatus() == Artigo.StatusArtigo.APROVADO){
            throw new IllegalStateException("Artigos aprovados não podem ser aprovados");
        }
        artigoExistente.setTitulo(novosDados.getTitulo());
        artigoExistente.setStatus(novosDados.getStatus());
        artigoExistente.setPalavrasChave(novosDados.getPalavrasChave());
        artigoExistente.setArquivoInicial(novosDados.getArquivoInicial());
        artigoExistente.setArquivoFinal(novosDados.getArquivoFinal());
        artigoExistente.setAreaTematica(novosDados.getAreaTematica());
    }

    public void aprovaArtigo(Artigo artigo) {
        if (artigo.getStatus() != Artigo.StatusArtigo.REVISAO_SOLICITADA) {
            throw new IllegalStateException("O artigo so pode ser aceito apos revisao");
        }
        artigo.setStatus(Artigo.StatusArtigo.APROVADO);
    }

    public void rejeitarArtigo(Artigo artigo){
        artigo.setStatus(Artigo.StatusArtigo.REJEITADO);
    }

    public ArtigoAnonimoDTO getArtigoAnonimo(Long id) {
        return ArtigoRepository.findArtigoAnonimoById(id);
    }

}