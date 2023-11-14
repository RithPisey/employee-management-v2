package kh.gov.rac.racsa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsGlobalConfiguration extends org.springframework.web.cors.CorsConfiguration {
    public static final Long expire =  60L * 60 * 24;
    @Bean
    public CorsWebFilter corsWebFilter() {

        final CorsGlobalConfiguration corsConfig = new CorsGlobalConfiguration();
        corsConfig.setAllowedOriginPatterns(List.of("*"));
        corsConfig.setMaxAge(expire);
        corsConfig.setAllowedMethods(List.of("*"));
        corsConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}