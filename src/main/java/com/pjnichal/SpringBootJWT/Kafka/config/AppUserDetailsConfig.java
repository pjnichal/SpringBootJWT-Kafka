package com.pjnichal.SpringBootJWT.Kafka.config;

import com.pjnichal.SpringBootJWT.Kafka.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class AppUserDetailsConfig {
    @Autowired
    private AppUserRepo appUserRepo;
    @Bean
    //authentication
    public UserDetailsService userDetailsService() {

        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return appUserRepo.findByEmail(username).orElseThrow();

            }
        };
    }
}
