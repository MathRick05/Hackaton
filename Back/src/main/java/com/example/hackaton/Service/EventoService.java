package com.example.hackaton.Service;

import com.example.hackaton.model.Evento;
import com.example.hackaton.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento criar(Evento evento) {
        validarDados(evento);
        return eventoRepository.save(evento);
    }

    public Evento atualizar(Evento evento) {
        if (!eventoRepository.existsById(evento.getId())) {
            throw new IllegalArgumentException("Evento não encontrado.");
        }
        validarDados(evento);
        return eventoRepository.save(evento);
    }

    private void validarDados(Evento evento) {
        if (evento.getNome() == null || evento.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do evento é obrigatório.");
        }
        if (evento.getDescricao() == null || evento.getDescricao().isBlank()) {
            throw new IllegalArgumentException("Descrição do evento é obrigatória.");
        }
        if (evento.getOrganizador() == null) {
            throw new IllegalArgumentException("O evento deve ter um coordenador responsável.");
        }
        if (evento.getDataInicio().isAfter(evento.getPrazoSubmissaoFinal()) ||
            evento.getPrazoSubmissaoFinal().isAfter(evento.getPrazoAvaliacao()) ||
            evento.getPrazoAvaliacao().isAfter(evento.getDataFim())) {
            throw new IllegalArgumentException("Datas do evento estão em ordem inválida.");
        }
    }

    public List<Evento> listarTodos() {
        return eventoRepository.findAll();
    }

    public Evento buscarPorId(Long id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Evento não encontrado com ID: " + id));
    }

}
