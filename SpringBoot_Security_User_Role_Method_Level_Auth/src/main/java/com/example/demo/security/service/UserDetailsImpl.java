package com.example.demo.security.service;

import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private boolean isTwoFactorEnabled;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String username, String password, String email, boolean isTwoFactorEnabled, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isTwoFactorEnabled = isTwoFactorEnabled;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getRoleName().name());
        return new UserDetailsImpl(
                user.getUserName(),
                user.getPassword(),
                user.getEmail(),
                user.isTwoFactorEnabled(),
                List.of(authority)
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implement logic if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement logic if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement logic if needed
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement logic if needed
    }

    public boolean isTwoFactorEnabled() {
        return isTwoFactorEnabled;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        UserDetailsImpl user = (UserDetailsImpl) o;
//        return Objects.equals(id, user.id);
//    }
}
