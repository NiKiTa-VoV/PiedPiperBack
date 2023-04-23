package ru.piedpipers.backend.database.repository.realisation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.piedpipers.backend.database.model.base.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}