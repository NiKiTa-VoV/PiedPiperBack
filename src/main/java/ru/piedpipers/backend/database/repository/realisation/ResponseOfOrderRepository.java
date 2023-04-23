package ru.piedpipers.backend.database.repository.realisation;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.piedpipers.backend.database.model.entity.ResponseOfOrder;

public interface ResponseOfOrderRepository extends JpaRepository<ResponseOfOrder, Integer> {

}