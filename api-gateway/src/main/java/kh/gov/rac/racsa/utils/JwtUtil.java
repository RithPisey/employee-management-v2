package kh.gov.rac.racsa.utils;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import kh.gov.rac.racsa.dto.TokenPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.security.Key;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtUtil {

    @Autowired
    private WebClient.Builder webClientBuilder;
    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }



    private Key getSignKey() {
        String SECRET = webClientBuilder.build().get().uri("http://config-service/api/config/secret-token").retrieve().bodyToMono(String.class).block();
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    private TokenPayload getPayload(String token){
         return (TokenPayload) Jwts
                 .parserBuilder()
                 .setSigningKey(getSignKey())
                 .build()
                 .parseClaimsJws(token)
                 .getBody();
    }

}
