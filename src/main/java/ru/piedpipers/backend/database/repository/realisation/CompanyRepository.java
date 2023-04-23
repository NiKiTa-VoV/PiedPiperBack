package ru.piedpipers.backend.database.repository.realisation;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.piedpipers.backend.database.model.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}