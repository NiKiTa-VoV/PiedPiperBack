package ru.skzmk.backend.database.repository.realisation;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skzmk.backend.database.model.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

}