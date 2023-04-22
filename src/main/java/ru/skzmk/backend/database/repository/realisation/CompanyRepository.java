package ru.skzmk.backend.database.repository.realisation;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skzmk.backend.database.model.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}