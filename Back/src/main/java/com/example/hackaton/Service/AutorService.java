package com.example.hackaton.Service;
import com.example.hackaton.model.Autor;
import com.example.hackaton.repository.AutorRepository;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor CriarAutor(Autor autor) {
        validarEmail(autor.getEmail());
        validarAfiliacao(autor.getFiliacao());
        return autorRepository.save(autor);
    }

    private void validarEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (email == null || !email.matches(regex)){
            throw new IllegalArgumentException("Email-Invalido");
        }
    }

    private void validarAfiliacao(String filiacao) {
        if (filiacao == null || !filiacao.toLowerCase().contains("universidade")){
            throw new IllegalArgumentException("Filiacao deve ter um nome de universidade");
        }
    }
}
