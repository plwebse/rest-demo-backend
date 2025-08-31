package se.plweb.rest_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {

        return args -> {
            for (int i = 0; i < 300; i++) {
                repository.add(new Customer("Peter Lindblom" + i, "Peter's address", "email" + i + "@plweb.se", "070" + i));
            }
        };
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173/")
                        .allowedOrigins("http://localhost:8080/")
                        .allowedOrigins("http://localhost:8081/")
                        .allowedOrigins("http://127.0.0.1:5173/")
                        .allowedOrigins("http://127.0.0.1:8080/")
                        .allowedOrigins("http://127.0.0.1:8081/");

            }
        };
    }


}


