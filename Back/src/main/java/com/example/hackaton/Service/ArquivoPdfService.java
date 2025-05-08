package com.example.hackaton.Service;

import com.example.hackaton.model.ArquivoPdf;
import com.example.hackaton.repository.ArquivoPdfRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ArquivoPdfService {

    private final ArquivoPdfRepository repository;

    private final String pastaUpload = "uploads/";

    public ArquivoPdfService(ArquivoPdfRepository repository) {
        this.repository = repository;
    }

    public ArquivoPdf salvarArquivo(MultipartFile file) throws IOException {
        if (file.isEmpty() || !file.getOriginalFilename().endsWith(".pdf")) {
            throw new IllegalArgumentException("Arquivo inválido. Apenas PDFs são permitidos.");
        }

        Files.createDirectories(Paths.get(pastaUpload));

        String nomeArquivo = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path caminho = Paths.get(pastaUpload + nomeArquivo);
        Files.write(caminho, file.getBytes());

        ArquivoPdf pdf = new ArquivoPdf();
        pdf.setNomeOriginal(file.getOriginalFilename());
        pdf.setCaminhoArquivo(caminho.toString());

        return repository.save(pdf);
    }
}
