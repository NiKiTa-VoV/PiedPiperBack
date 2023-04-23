package ru.piedpipers.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.piedpipers.backend.database.model.entity.Document;
import ru.piedpipers.backend.database.repository.realisation.DocumentRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("resource")
public class ResourceController {

    private final DocumentRepository documentRepository;

    @PostMapping("/upload")
    public ResponseEntity<?> loadFile(MultipartFile file) {
        if (!file.isEmpty()) {
            String name = file.getOriginalFilename();
            try {
                byte[] bytes = file.getBytes();
                Document document = new Document();
                long count = documentRepository.count() + 1;
                document.setFileName(count + "-" + file.getOriginalFilename());
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream("D:\\projects\\hack\\3\\files\\" + document.getFileName()));
                stream.write(bytes);
                stream.close();
                document = documentRepository.save(document);
                return ResponseEntity.ok(document.getId());
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Вам не удалось загрузить " + name + " => " + e.getMessage());
            }
        } else {
            return ResponseEntity.badRequest().body("Вам не удалось загрузить потому что файл пустой.");
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Resource> photoResource(HttpServletResponse response, @PathVariable("id") String id) throws IOException {
        Document document = documentRepository.findById(Integer.valueOf(id)).get();
        String filePath = "D:\\projects\\hack\\3\\files\\" + document.getFileName();
        Resource resource = new FileSystemResource(filePath);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.getFile().length())
                .body(resource);
    }
}
