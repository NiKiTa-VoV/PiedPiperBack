package ru.skzmk.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skzmk.backend.database.model.base.User;
import ru.skzmk.backend.database.repository.realisation.UserRepository;
import ru.skzmk.backend.general.message.realization.misc.UserDto;
import ru.skzmk.backend.security.data.CurrentUser;
import ru.skzmk.backend.security.data.UserPrincipal;

@RequiredArgsConstructor
@RestController

@RequestMapping("user")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/me")
    public ResponseEntity<UserDto> getMy(@CurrentUser UserPrincipal principal) {
        User user = userRepository.findById(principal.getId()).get();

        UserDto userDto = new UserDto(user.getId(), user.getUuid(), user.getEmail(), user.getCompany());
        return ResponseEntity.ok(userDto);
    }
}
