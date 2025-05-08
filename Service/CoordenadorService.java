package com.example.hackaton.Service;

import com.example.hackaton.model.Coordenador;
import com.example.hackaton.repository.CoordenadorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoordenadorService {

    private final CoordenadorRepository coordenadorRepository;

    public CoordenadorService(CoordenadorRepository coordenadorRepository) {
        this.coordenadorRepository = coordenadorRepository;
    }

    public Coordenador criar(Coordenador coordenador) {
        validarDados(coordenador);
        validarUsuarioUnico(coordenador.getUsuario());
        return coordenadorRepository.save(coordenador);
    }

    public Coordenador atualizar(Coordenador coordenador) {
        if (coordenador.getId() == null || !coordenadorRepository.existsById(coordenador.getId())) {
            throw new IllegalArgumentException("Coordenador não encontrado.");
        }
        validarDados(coordenador);
        return coordenadorRepository.save(coordenador);
    }

    private void validarDados(Coordenador coordenador) {
        if (coordenador.getNome() == null || coordenador.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        if (coordenador.getUsuario() == null || coordenador.getUsuario().trim().isEmpty()) {
            throw new IllegalArgumentException("O usuário não pode ser vazio.");
        }
        if (coordenador.getSenhaHash() == null || coordenador.getSenhaHash().trim().isEmpty()) {
            throw new IllegalArgumentException("A senha não pode ser vazia.");
        }
    }

    private void validarUsuarioUnico(String usuario) {
        Optional<Coordenador> existente = coordenadorRepository.findByUsuario(usuario);
        if (existente.isPresent()) {
            throw new IllegalStateException("Este nome de usuário já está em uso.");
        }
    }
}
