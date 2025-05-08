package com.example.hackaton.Submissao_artigos.Service; // Ou com.example.hackaton.service

import com.example.hackaton.Submissao_artigos.Service.StorageException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class StorageService {

    @Value("${file.upload-dir}") // Você precisará definir isso no application.properties
    private String uploadDirString;

    private Path rootLocation;

    @PostConstruct
    public void init() {
        this.rootLocation = Paths.get(uploadDirString);
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Não foi possível inicializar o diretório de upload: " + uploadDirString, e);
        }
    }

    public String store(MultipartFile file) {
        if (file.isEmpty()) {
            throw new StorageException("Falha ao armazenar arquivo vazio.");
        }
        // Validações adicionais, como tipo de arquivo, podem ser feitas aqui ou no controller
        // Ex: if (!"application/pdf".equals(file.getContentType())) { ... }

        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        String extension = "";
        int i = originalFilename.lastIndexOf('.');
        if (i > 0 && i < originalFilename.length() - 1) {
            extension = originalFilename.substring(i);
        }
        String storedFilename = UUID.randomUUID().toString() + extension;

        try {
            Path destinationFile = this.rootLocation.resolve(storedFilename).normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                throw new StorageException("Não é possível armazenar arquivo fora do diretório raiz de upload: " + originalFilename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
            return storedFilename;
        } catch (IOException e) {
            throw new StorageException("Falha ao armazenar o arquivo " + originalFilename, e);
        }
    }

    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    // Se precisar servir os arquivos, você pode adicionar um método como:
    // public org.springframework.core.io.Resource loadAsResource(String filename) { ... }
}