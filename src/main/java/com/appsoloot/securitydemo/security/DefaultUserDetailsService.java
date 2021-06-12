package com.appsoloot.securitydemo.security;

import com.appsoloot.securitydemo.model.User;
import com.appsoloot.securitydemo.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public DefaultUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByName(username);
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), List.of());
    }
}
