package ru.piedpipers.backend.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.piedpipers.backend.database.model.base.User;
import ru.piedpipers.backend.database.repository.realisation.UserRepository;
import ru.piedpipers.backend.security.data.UserPrincipal;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> getUser(UserPrincipal principal) {
        return userRepository.findById(principal.getId());
    }
}
