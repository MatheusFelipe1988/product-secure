package com.system.security.configuration;

import com.system.security.domain.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
public class UserPrincipal {
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    private UserPrincipal(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();

        this.authorities = user.getRoles().stream().map(role -> {
            return new SimpleGrantedAuthority("ROLE_ ".concat(role.getNome()));
        }).collect(Collectors.toList());
    }

    public static UserPrincipal create(User user){
        return new UserPrincipal(user);
    }
}
