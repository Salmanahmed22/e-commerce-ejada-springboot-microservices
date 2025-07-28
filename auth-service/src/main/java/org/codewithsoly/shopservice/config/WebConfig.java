package org.codewithsoly.shopservice.config;


import org.codewithsoly.shopservice.repo.UserRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebConfig {
    private final UserRepo userRepo;

    public WebConfig(UserRepo userRepository) {
        this.userRepo = userRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepo
                .findById(Integer.valueOf(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

