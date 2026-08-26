package redhat.engineering.ebikes.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import redhat.engineering.ebikes.entities.Service_User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class UserInfoUserDetails implements UserDetails {
    private String username;
    private String password;
    private Long id;
    private Collection<? extends GrantedAuthority> authorities;

    public UserInfoUserDetails(Service_User user) {
        this.username = user.getFullname();
        this.password = user.getPassword();
        this.id = user.getId();
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getUserRole()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
