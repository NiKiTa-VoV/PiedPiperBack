package ru.skzmk.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skzmk.backend.database.model.entity.Application;
import ru.skzmk.backend.database.repository.realisation.ApplicationRepository;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationRepository applicationRepository;

    @GetMapping
    public ResponseEntity<List<Application>> getApplications() {
        return ResponseEntity.ok(applicationRepository.findAll());
    }
}
