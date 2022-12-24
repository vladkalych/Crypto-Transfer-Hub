package com.rebalcomb.security.jwt;

import com.rebalcomb.model.entity.User;
import com.rebalcomb.model.entity.enums.Role;
import com.rebalcomb.model.entity.enums.Status;
import com.rebalcomb.security.SecurityUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static SecurityUser create(User user) {
        return new SecurityUser(
                user.getUsername(),
                user.getPassword(),
                roleToGrantedAuthorities(user.getRole().getAuthorities()),
                user.getStatus().equals(Status.ACTIVE)
        );
    }

    private static List<SimpleGrantedAuthority> roleToGrantedAuthorities(Set<SimpleGrantedAuthority> userRoles) {
        return new ArrayList<>(userRoles);
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.name())
                ).collect(Collectors.toList());
    }
}
