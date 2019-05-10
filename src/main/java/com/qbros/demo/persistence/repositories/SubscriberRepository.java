package com.qbros.demo.persistence.repositories;

import com.qbros.demo.persistence.JPA.entities.SubscriberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;


@Repository
@Transactional
public interface SubscriberRepository extends PagingAndSortingRepository<SubscriberEntity, Long> {
    void deleteByUserId(long userId);

    Optional<SubscriberEntity> findByUserId(long userId);

    Optional<SubscriberEntity> findByUserIdAndId(long userId, long id);

    Page<SubscriberEntity> getSubscriberByCreatedAtIsAfter(Date date, Pageable pageable);

    Page<SubscriberEntity> getSubscriberByCreatedAtIsBefore(Date date, Pageable pageable);

    Page<SubscriberEntity> getSubscriberByUserId(Long userId, Pageable pageable);


}
