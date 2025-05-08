package com.example.hackaton.Service;

import com.example.hackaton.model.Avaliacao;
import com.example.hackaton.model.Avaliacao.Recomendacao;
import com.example.hackaton.model.Avaliacao.Status;
import com.example.hackaton.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Avaliacao> listarTodas() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao buscarPorId(int id) {
        return avaliacaoRepository.findById(id).orElse(null);
    }

    public Avaliacao atualizar(int id, Avaliacao avaliacaoAtualizada) {
        Optional<Avaliacao> existente = avaliacaoRepository.findById(id);
        if (existente.isEmpty()) return null;

        Avaliacao original = existente.get();
        original.setNota(avaliacaoAtualizada.getNota());
        original.setParecer(avaliacaoAtualizada.getParecer());
        original.setComentarioAutor(avaliacaoAtualizada.getComentarioAutor());
        original.setComentarioCoordenador(avaliacaoAtualizada.getComentarioCoordenador());
        original.setMetodo(avaliacaoAtualizada.getMetodo());
        original.setRecomendacao(avaliacaoAtualizada.getRecomendacao());
        definirStatusPorRecomendacao(original);

        return avaliacaoRepository.save(original);
    }

    public boolean deletar(int id) {
        Optional<Avaliacao> existente = avaliacaoRepository.findById(id);
        if (existente.isEmpty()) return false;
        avaliacaoRepository.deleteById(id);
        return true;
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
