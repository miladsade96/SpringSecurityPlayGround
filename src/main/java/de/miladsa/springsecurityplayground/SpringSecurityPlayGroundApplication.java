package de.miladsa.springsecurityplayground;

import de.miladsa.springsecurityplayground.models.User;
import de.miladsa.springsecurityplayground.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityPlayGroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityPlayGroundApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return (args -> {
            var user1 = new User();
            user1.setUsername("milad");
            user1.setPassword(passwordEncoder.encode("123"));
            userRepository.save(user1);
        });
    }
}
