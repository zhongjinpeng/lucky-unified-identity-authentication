package io.lucky.unified.identity.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication(scanBasePackages = "io.lucky")
@EnableDiscoveryClient
@EnableOpenApi
public class LuckyUnifiedIdentityAuthentication {

    public static void main(String[] args) {
        SpringApplication.run(LuckyUnifiedIdentityAuthentication.class, args);
    }

}
