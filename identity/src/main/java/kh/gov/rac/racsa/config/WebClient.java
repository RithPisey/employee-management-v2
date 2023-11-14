package kh.gov.rac.racsa.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebClient {
    @Bean
    @LoadBalanced
    public org.springframework.web.reactive.function.client.WebClient.Builder webClientBuilder(){
        return org.springframework.web.reactive.function.client.WebClient.builder();
    }
}
