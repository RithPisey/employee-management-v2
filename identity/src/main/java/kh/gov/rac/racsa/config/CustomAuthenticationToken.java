package kh.gov.rac.racsa.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private final String role;
    public CustomAuthenticationToken(Object principal, Object credentials,String role){
        super(principal, credentials);
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
