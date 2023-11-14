package kh.gov.rac.racsa.filter;

import kh.gov.rac.racsa.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Component
@Slf4j
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {


    @Autowired
    private RouteValidator validator;
    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if(validator.isSecured.test(exchange.getRequest())){
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new ResponseStatusException(HttpStatus.NON_AUTHORITATIVE_INFORMATION,
                            "missing authorization header");
                }

                String token = Objects.requireNonNull(exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION)).get(0);
                if (token != null && token.startsWith("Bearer ")) {
                    token = token.substring(7);
                }
                try {
                    // REST call to AUTH service
                    // template.getForObject("http://IDENTITY-SERVICE//validate?token" + token,
                    // String.class);
                    jwtUtil.validateToken(token);

                } catch (Exception e) {
                    System.out.println("invalid access...!");
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "un authorized access to application");
                }
            }else{

            }
            return chain.filter(exchange);
        });
    }


    public static class Config {
    }
}
