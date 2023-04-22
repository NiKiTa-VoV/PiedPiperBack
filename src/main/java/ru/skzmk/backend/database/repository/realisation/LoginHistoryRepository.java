package ru.skzmk.backend.database.repository.realisation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skzmk.backend.database.model.base.LoginHistory;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Integer> {
}