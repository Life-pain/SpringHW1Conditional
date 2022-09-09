package com.example.conditional.config;

import com.example.conditional.profile.DevProfile;
import com.example.conditional.profile.ProductionProfile;
import com.example.conditional.profile.SystemProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "true")
    @Bean
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
