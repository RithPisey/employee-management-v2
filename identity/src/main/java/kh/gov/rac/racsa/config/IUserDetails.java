package kh.gov.rac.racsa.config;

import kh.gov.rac.racsa.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IUserDetails implements UserDetails {

     private final User userCredential;

    public IUserDetails(User userCredential){
        this.userCredential = userCredential;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(this.userCredential.getRole().getId().toString()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.userCredential.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userCredential.getEmail();
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
