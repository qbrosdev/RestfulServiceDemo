package com.qbros.demo.service.implementations;

import com.qbros.demo.persistence.JPA.entities.SubscriberEntity;
import com.qbros.demo.persistence.repositories.SubscriberRepository;
import com.qbros.demo.service.interfaces.NewsletterSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
public class BasicNewsletterSubscriptionService extends NewsletterSubscriptionService {

    @Autowired
    public BasicNewsletterSubscriptionService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public boolean checkTask(int taskID) {
        return false;
    }

    @Override
    public void deleteByUserId(long userId) {
        subscriberRepository.deleteByUserId(userId);
    }

    @Override
    public SubscriberEntity findByUserId(long userId) {
        return subscriberRepository.findByUserId(userId).
                orElseThrow(() -> new EntityNotFoundException("entity with userId " + userId + " not found"));
    }

    @Override
    public Page<SubscriberEntity> getAllSubscribedBeforePaged(Date beforeDate, Pageable pageable) {
        return subscriberRepository.getSubscriberByCreatedAtIsBefore(beforeDate,pageable);
    }

    @Override
    public Page<SubscriberEntity> getAllSubscribedAfterPaged(Date afterDate, Pageable pageable) {
        return subscriberRepository.getSubscriberByCreatedAtIsAfter(afterDate,pageable);
    }

    @Override
    public Page<SubscriberEntity> getSubscriptionForUserIdPaged(long userID, Pageable pageable) {
        return subscriberRepository.getSubscriberByUserId(userID,pageable);
    }
}
