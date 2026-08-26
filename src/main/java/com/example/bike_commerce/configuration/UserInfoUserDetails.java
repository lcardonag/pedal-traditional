package com.example.bike_commerce.configuration;

import com.example.bike_commerce.customers.entities.Customer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class UserInfoUserDetails implements UserDetails {
    private String name;
    private String password;
    private String authorities;

    private String email;

    private Long id;

    public UserInfoUserDetails(Customer user) {
        name=user.getFullname();
        password=user.getPassword();
        email=user.getEmail();
        id=user.getId();
        authorities= Arrays.stream(user.getUser_role().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList()).toString();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
