package com.example.hackaton.service;

import com.example.hackaton.model.Avaliacao;
import com.example.hackaton.model.Avaliacao.Recomendacao;
import com.example.hackaton.model.Avaliacao.Status;
import com.example.hackaton.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public Avaliacao avaliar(Avaliacao avaliacao) {
        validarNota(avaliacao.getNota());
        validarParecer(avaliacao.getParecer());
        verificarDuplicidade(avaliacao.getArtigo().getId(), avaliacao.getAvaliador().getId());

        definirStatusPorRecomendacao(avaliacao);

        return avaliacaoRepository.save(avaliacao);
    }

    private void validarNota(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota deve ser entre 0 e 10.");
        }
    }

    private void validarParecer(String parecer) {
        if (parecer == null || parecer.trim().isEmpty()) {
            throw new IllegalArgumentException("O parecer não pode ser vazio.");
        }
    }

    private void verificarDuplicidade(Long artigoId, Long avaliadorId) {
        Optional<Avaliacao> existente = avaliacaoRepository.findByArtigoIdAndAvaliadorId(artigoId, avaliadorId);
        if (existente.isPresent()) {
            throw new IllegalStateException("Este avaliador já avaliou este artigo.");
        }
    }

    private void definirStatusPorRecomendacao(Avaliacao avaliacao) {
        Recomendacao recomendacao = avaliacao.getRecomendacao();
        if (recomendacao == null) return;

        switch (recomendacao) {
            case Aprovar:
                avaliacao.setStatus(Status.Aprovado);
                break;
            case Rejeitar:
                avaliacao.setStatus(Status.Rejeitado);
                break;
            case Revisar:
                avaliacao.setStatus(Status.RevisaoSolicitada);
                break;
        }
    }
}
