package com.example.hackaton.Service;

import com.example.hackaton.Controller.ArtigoAnonimoDTO;
import com.example.hackaton.model.Artigo;
import com.example.hackaton.model.Historico;
import com.example.hackaton.repository.ArtigoRepository;
import com.example.hackaton.repository.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ArtigoService {

    private final ArtigoRepository artigoRepository;
    private final HistoricoRepository historicoRepository;

    @Autowired
    public ArtigoService(ArtigoRepository artigoRepository, HistoricoRepository historicoRepository) {
        this.artigoRepository = artigoRepository;
        this.historicoRepository = historicoRepository;
    }

    public Artigo criarArtigo(Artigo artigo) {
        validarCriacao(artigo);
        return artigoRepository.save(artigo);
    }

    public void validarCriacao(Artigo artigo) {
        if (artigo.getPalavrasChave() == null || artigo.getPalavrasChave().size() < 2) {
            throw new IllegalArgumentException("O artigo tem menos que 2 palavras-chave");
        }
        artigo.setStatus(Artigo.StatusArtigo.EM_AVALIACAO);
    }

    public void validarAtualizacao(Artigo artigoExistente, Artigo novosDados) {
        if (artigoExistente.getStatus() == Artigo.StatusArtigo.APROVADO) {
            throw new IllegalStateException("Artigos aprovados não podem ser atualizados");
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
            throw new IllegalStateException("O artigo só pode ser aceito após revisão");
        }
        artigo.setStatus(Artigo.StatusArtigo.APROVADO);
    }

    public void rejeitarArtigo(Artigo artigo) {
        artigo.setStatus(Artigo.StatusArtigo.REJEITADO);
    }

    public ArtigoAnonimoDTO getArtigoAnonimo(Long id) {
        return ArtigoRepository.findArtigoAnonimoById(id);
    }

    public String solicitarRevisao(Long artigoId) {
        Artigo artigo = artigoRepository.findById(artigoId)
                .orElseThrow(() -> new RuntimeException("Artigo não encontrado"));

        if (artigo.getStatus() != Artigo.StatusArtigo.SUBMETIDO) {
            throw new IllegalStateException("Revisão só pode ser solicitada se o artigo estiver SUBMETIDO.");
        }

        artigo.setStatus(Artigo.StatusArtigo.EM_REVISAO);
        artigoRepository.save(artigo);

        Historico historico = new Historico();
        historico.setArtigo(artigo);
        historico.setDataAcao(LocalDate.now());
        historico.setDescricao("Revisão solicitada para o artigo.");
        historicoRepository.save(historico);

        return "Revisão solicitada com sucesso.";
    }

}
