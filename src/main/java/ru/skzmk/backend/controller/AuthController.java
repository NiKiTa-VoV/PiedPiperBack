package ru.skzmk.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.skzmk.backend.database.model.base.User;
import ru.skzmk.backend.database.repository.realisation.UserRepository;
import ru.skzmk.backend.general.message.realization.user.auth.ApiResponse;
import ru.skzmk.backend.general.message.realization.user.auth.AuthResponse;
import ru.skzmk.backend.general.message.realization.user.auth.LoginRequest;
import ru.skzmk.backend.general.message.realization.user.auth.SignUpRequest;
import ru.skzmk.backend.security.data.UserPrincipal;
import ru.skzmk.backend.security.service.TokenProvider;
import ru.skzmk.backend.security.service.UserPrincipalCreator;
import ru.skzmk.backend.util.exception.BadRequestException;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final UserPrincipalCreator principalCreator;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Optional<User> optionalUser = userRepository.findByEmail(loginRequest.email());
        if (optionalUser.isEmpty()) return ResponseEntity.notFound().build();

        if (!passwordEncoder.matches(loginRequest.password(), optionalUser.get().getPassword())) {
            return ResponseEntity.badRequest().build();
        }

        UserPrincipal principal = principalCreator.create(optionalUser.get());
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(principal,
                null,
                principal.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }

        // Creating user's account
        User user = new User();
        user.setUuid(UUID.randomUUID());
        user.setEmail(signUpRequest.getEmail());

        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(result.getId()).toUri();

        // TODO: 01.04.2023 Не возвращает токен
        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "User registered successfully@"));
    }

}
