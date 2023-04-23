package ru.skzmk.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skzmk.backend.database.model.entity.ResponseOfOrder;
import ru.skzmk.backend.database.repository.realisation.ResponseOfOrderRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("response_order")
public class ResponseOfOrderController {

    private final ResponseOfOrderRepository responseOfOrderRepository;

    @GetMapping
    public ResponseEntity<List<ResponseOfOrder>> responses() {
        return ResponseEntity.ok(responseOfOrderRepository.findAll());
    }
}
