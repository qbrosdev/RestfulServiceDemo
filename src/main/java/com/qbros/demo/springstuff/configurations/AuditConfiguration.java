package com.qbros.demo.springstuff.configurations;

import com.qbros.demo.persistence.DbAuditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditConfiguration {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new DbAuditor();
    }
}

