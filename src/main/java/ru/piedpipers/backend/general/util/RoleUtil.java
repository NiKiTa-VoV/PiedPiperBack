package ru.piedpipers.backend.general.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.piedpipers.backend.database.model.base.Role;
import ru.piedpipers.backend.security.data.RoleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RoleUtil {

    public static List<GrantedAuthority> rolesToGrantedAuthority(Set<Role> roles) {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>(roles.size());

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName().toUpperCase().replaceAll(" ", "_")));
        }

        return authorities;
    }

    public static boolean containRole(Set<Role> roles, RoleType type) {
        for (Role role : roles) {
            if (role.getName().equals(type.getName())) {
                return true;
            }
        }

        return false;
    }

}
