package ru.skzmk.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.skzmk.backend.database.model.base.User;
import ru.skzmk.backend.database.model.entity.Company;
import ru.skzmk.backend.database.repository.realisation.CompanyRepository;
import ru.skzmk.backend.database.repository.realisation.UserRepository;
import ru.skzmk.backend.security.data.CurrentUser;
import ru.skzmk.backend.security.data.UserPrincipal;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/company")
@RequiredArgsConstructor
@Transactional
public class CompanyController {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    @GetMapping("/me")
    public ResponseEntity<Company> getMyCompany(@CurrentUser UserPrincipal principal) {
        User user = userRepository.findById(principal.getId()).get();

        if (user.getCompany() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user.getCompany());
    }

    @PutMapping("/me")
    public void updateCompany(@CurrentUser UserPrincipal principal, @Valid @RequestBody Company company) {
        User user = userRepository.findById(principal.getId()).get();

        company = companyRepository.save(company);
        user.setCompany(company);
    }
}
