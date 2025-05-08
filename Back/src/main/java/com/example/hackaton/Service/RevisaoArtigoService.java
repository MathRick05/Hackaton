package com.example.hackaton.Service;

import com.example.hackaton.model.RevisaoArtigo;
import com.example.hackaton.repository.RevisaoArtigoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class RevisaoArtigoService {

    private final RevisaoArtigoRepository revisaoRepository;

    public RevisaoArtigoService(RevisaoArtigoRepository revisaoRepository) {
        this.revisaoRepository = revisaoRepository;
    }

    public RevisaoArtigo enviarRevisao(RevisaoArtigo revisao) {
        validar(revisao);
        return revisaoRepository.save(revisao);
    }

    private void validar(RevisaoArtigo revisao) {
        if (revisao.getArtigo() == null) {
            throw new IllegalArgumentException("A revisão deve estar vinculada a um artigo.");
        }
        if (revisao.getArquivoPdf() == null || revisao.getArquivoPdf().isBlank()) {
            throw new IllegalArgumentException("Arquivo PDF obrigatório.");
        }
        if (revisao.getDataEnvio() == null || revisao.getDataEnvio().after(new Date())) {
            throw new IllegalArgumentException("Data de envio inválida.");
        }
        if (revisao.getTipo() == RevisaoArtigo.Tipo.Inicial) {
            Optional<RevisaoArtigo> existente = revisaoRepository.findFirstByArtigoIdAndTipo(
                revisao.getArtigo().getId(), RevisaoArtigo.Tipo.Inicial);
            if (existente.isPresent()) {
                throw new IllegalStateException("O artigo já possui uma versão inicial cadastrada.");
            }
        }
    }
}
