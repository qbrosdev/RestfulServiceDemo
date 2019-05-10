package com.qbros.demo.springstuff;

import com.qbros.demo.persistence.repositories.SubscriberRepository;
import com.qbros.demo.service.entityDtoMapper.SubscriptionMapper;
import com.qbros.demo.service.implementations.BasicNewsletterSubscriptionService;
import com.qbros.demo.service.interfaces.NewsletterSubscriptionService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * here we can control and also log each instance creation
 */
@Configuration
public class DependencyProvider {

    @Bean
    @Scope(scopeName = "singleton")
    public NewsletterSubscriptionService basicService(SubscriberRepository subscriberRepository) {
        return new BasicNewsletterSubscriptionService(subscriberRepository);
    }

    @Bean
    @Scope(scopeName = "singleton")
    public SubscriptionMapper modelMapper2(ModelMapper modelMapper) {
        return new SubscriptionMapper(modelMapper);
    }

    @Bean
    @Scope(scopeName = "singleton")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
