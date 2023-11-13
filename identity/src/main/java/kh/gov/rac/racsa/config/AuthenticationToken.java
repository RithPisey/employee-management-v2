package kh.gov.rac.racsa.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthenticationToken extends UsernamePasswordAuthenticationToken {

    private final String role;
    public AuthenticationToken(Object principal, Object credentials,String role){
        super(principal, credentials);
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
