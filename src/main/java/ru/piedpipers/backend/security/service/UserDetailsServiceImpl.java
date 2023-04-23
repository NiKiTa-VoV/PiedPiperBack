package ru.piedpipers.backend.security.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.piedpipers.backend.database.model.base.User;
import ru.piedpipers.backend.database.repository.realisation.UserRepository;

import java.util.UUID;

/**
 *
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserPrincipalCreator principalCreator;
    
    @Override
    public UserDetails loadUserByUsername(String uuid)
            throws UsernameNotFoundException {
        System.out.println("uuid = " + uuid);
        User user = userRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with uuid : " + uuid));

        return principalCreator.create(user);
    }
}