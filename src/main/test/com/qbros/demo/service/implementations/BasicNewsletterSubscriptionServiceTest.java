package com.qbros.demo.service.implementations;

import com.qbros.demo.persistence.JPA.entities.SubscriberEntity;
import com.qbros.demo.persistence.repositories.SubscriberRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

@RunWith(MockitoJUnitRunner.class)
public class BasicNewsletterSubscriptionServiceTest {

    @Mock
    private SubscriberRepository mockedSubscriberRepository;

    private static BasicNewsletterSubscriptionService serviceUnderTest;
    private static SubscriberEntity mockedSubscriberEntity;
    private static Optional<SubscriberEntity> mockedRepositoryOptionalResult;
    private static PageImpl<SubscriberEntity>  mockedRepositoryPagedResult;
    private static Date mockedDate;


    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @BeforeClass
    public static void totalSetUp(){
        System.out.println("INIT TOTAL");
    }

    @Before
    public void setUp(){
        System.out.println("INIT EACH");
        serviceUnderTest = new BasicNewsletterSubscriptionService(mockedSubscriberRepository);
        mockedSubscriberEntity = SubscriberEntity.builder().userId(1L).build();
        mockedRepositoryOptionalResult = Optional.of(mockedSubscriberEntity);
        mockedRepositoryPagedResult = new PageImpl<>(Collections.singletonList(mockedSubscriberEntity));
        mockedDate = new Date();
    }

    @Test
    public void deleteByUserId() throws Exception {

    }

    @Test
    public void findByUserId() throws Exception {
        //init
        given(mockedSubscriberRepository.findByUserId(1L)).willReturn(mockedRepositoryOptionalResult);
        //perform
        SubscriberEntity subscriberEntity = serviceUnderTest.findByUserId(1L);
        //assert
        assertThat(subscriberEntity.getUserId()).isEqualTo(1L);
    }

    @Test
    public void findByUserId_notFound() throws Exception {
        //init
        given(mockedSubscriberRepository.findById(1L))
                .willReturn(Optional.ofNullable(null));
        exceptionRule.expect(EntityNotFoundException.class);
        exceptionRule.expectMessage("entity with userId " + 1 + " not found");
        //perform
        serviceUnderTest.findByUserId(1L);
    }

    @Test
    public void getAllSubscribedBeforePaged() throws Exception {
        //init
        given(mockedSubscriberRepository
                .getSubscriberByCreatedAtIsBefore(mockedDate, PageRequest.of(0,5)))
                .willReturn(mockedRepositoryPagedResult);
        //perform
        Page<SubscriberEntity> pagedResult = serviceUnderTest.getAllSubscribedBeforePaged(mockedDate, PageRequest.of(0,5));
        //assert
        assertThat(pagedResult.getTotalElements()).isEqualTo(1L);
    }

    @Test
    public void getAllSubscribedAfterPaged() throws Exception {
//        mockedSubscriberRepository.getSubscriberByCreatedAtIsBefore(beforeDate,pageable)
    }

    @Test
    public void getSubscriptionForUserIdPaged() throws Exception {

    }

}