package com.example.hackaton.Service;

import com.example.hackaton.model.Historico;
import com.example.hackaton.repository.HistoricoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class HistoricoService {

    private final HistoricoRepository historicoRepository;

    public HistoricoService(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public Historico gerarHistorico(Historico historico) {
        validar(historico);
        return historicoRepository.save(historico);
    }

    private void validar(Historico historico) {
        if (historico.getEvento() == null) {
            throw new IllegalArgumentException("O histórico deve estar vinculado a um evento.");
        }
        if (historico.getDataGeracao() == null || historico.getDataGeracao().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de geração inválida.");
        }
        if (historico.getArquivoUrl() == null || historico.getArquivoUrl().isBlank()) {
            throw new IllegalArgumentException("O histórico precisa ter um arquivo.");
        }
        if (historico.getFormato() == null) {
            throw new IllegalArgumentException("Formato do histórico é obrigatório.");
        }
    }

    public Optional<Historico> buscarPorEventoId(Long eventoId) {
        return Optional.ofNullable(historicoRepository.findByEventoId(eventoId));
    }

}
