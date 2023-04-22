package ru.skzmk.backend.security.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skzmk.backend.database.model.base.Role;
import ru.skzmk.backend.database.model.base.User;
import ru.skzmk.backend.database.repository.realisation.UserRepository;
import ru.skzmk.backend.general.util.RoleUtil;
import ru.skzmk.backend.security.data.UserPrincipal;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@Transactional
public class UserPrincipalCreator {
    private final UserRepository userRepository;

    public UserPrincipalCreator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserPrincipal create(User user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = create(user);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }

    public UserPrincipal create(User user) {
        user = userRepository.findById(user.getId()).get();
        Set<Role> roles = user.getRoles();
        List<GrantedAuthority> authorities = RoleUtil.rolesToGrantedAuthority(roles);
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new UserPrincipal(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getUuid(),
                authorities
        );
    }
}
