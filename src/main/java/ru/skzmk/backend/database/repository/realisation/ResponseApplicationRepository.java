package ru.skzmk.backend.database.repository.realisation;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skzmk.backend.database.model.entity.ResponseApplication;

public interface ResponseApplicationRepository extends JpaRepository<ResponseApplication, Integer> {
}