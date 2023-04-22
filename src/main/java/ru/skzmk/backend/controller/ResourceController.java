package ru.skzmk.backend.controller;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skzmk.backend.database.model.entity.Document;
import ru.skzmk.backend.database.repository.realisation.DocumentRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("resource")
public class ResourceController {

    private final DocumentRepository documentRepository;

    @PostMapping("file")
    public ResponseEntity<?> loadFile(MultipartFile file) {
        if (!file.isEmpty()) {
            String name = file.getOriginalFilename();
            try {
                byte[] bytes = file.getBytes();
                Document document = new Document();
                document.setOriginalName(name);
                String fileName = UUID.randomUUID() + name.split("\\.", 1)[0];
                document.setFileName(fileName);
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream("D:\\projects\\hack\\3\\files\\" + fileName));
                stream.write(bytes);
                stream.close();
                documentRepository.save(document);
                return ResponseEntity.ok(fileName);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Вам не удалось загрузить " + name + " => " + e.getMessage());
            }
        } else {
            return ResponseEntity.badRequest().body("Вам не удалось загрузить потому что файл пустой.");
        }
    }

    @GetMapping(value = "/{resource}")
    public void photoResource(HttpServletResponse response, @PathVariable("resource") String resource) throws IOException {
        Document document = documentRepository.findById(Integer.valueOf(resource)).get();
        FileInputStream in = new FileInputStream("D:\\projects\\hack\\3\\files\\" + document.getFileName());
        response.setContentType(MediaType.ALL_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }
}
