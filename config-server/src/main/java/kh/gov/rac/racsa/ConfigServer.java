package kh.gov.rac.racsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer.class,args);
    }
}