package com.example.hackaton.Service;


import com.example.hackaton.model.Avaliador;
import com.example.hackaton.repository.AutorRepository;
import com.example.hackaton.repository.AvaliadorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvaliadorService {
    public final AvaliadorRepository avaliadorRepository;

    public AvaliadorService(AvaliadorRepository avaliadorRepository) {
        this.avaliadorRepository = avaliadorRepository;
    }

    public Avaliador CriaAvaliador(Avaliador avaliador) {
        validarEmail(avaliador.getEmail());
        validarFiliacao(avaliador.getFiliacao());
        validarUsuarioUnico(avaliador.getUsuario());
        validarEmailUnico(avaliador.getEmail());

        return avaliadorRepository.save(avaliador);
    }

    public Avaliador atualizarAvaliador(Avaliador avaliador) {
        if (avaliador.getId() == null || !avaliadorRepository.existsById(avaliador.getId())) {
            throw new IllegalArgumentException("Avaliador não encontrado.");
        }
        validarEmail(avaliador.getEmail());
        validarFiliacao(avaliador.getFiliacao());
        return avaliadorRepository.save(avaliador);
    }

    private void validarEmail(String email) {
        String regex = "^[\\w.-]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (email == null || !email.matches(regex)) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
    }

    private void validarFiliacao(String filiacao) {
        if (filiacao == null || !filiacao.toLowerCase().contains("universidade")) {
            throw new IllegalArgumentException("A filiação deve conter o nome da universidade.");
        }
    }

    private void validarUsuarioUnico(String usuario) {
        Optional<Avaliador> existente = avaliadorRepository.findByUsuario(usuario);
        if (existente.isPresent()) {
            throw new IllegalStateException("Este nome de usuário já está em uso.");
        }
    }

    private void validarEmailUnico(String email) {
        Optional<Avaliador> existente = avaliadorRepository.findByEmail(email);
        if (existente.isPresent()) {
            throw new IllegalStateException("Este e-mail já está cadastrado.");
        }
    }
}