package com.qbros.demo.persistence.repositories;

import com.qbros.demo.persistence.JPA.entities.SubscriberEntity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class SubscriberRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    SubscriberRepository repositoryUnderTest;


    @After
    public void cleanUp(){
        repositoryUnderTest.deleteAll();
    }

    @Test
    public void save() throws Exception {
        SubscriberEntity savedEntity = testEntityManager.persistFlushFind(new SubscriberEntity(1L));
        Optional<SubscriberEntity> retrievedEntity = repositoryUnderTest
                .findByUserId(savedEntity.getUserId());
        assertThat(savedEntity).isEqualTo(retrievedEntity.orElse(null));
    }

    @Test
    public void deleteByUserId() throws Exception {

    }


    @Test
    public void deleteByUserId_Id_Not_Found() throws Exception {

    }

    @Test
    public void findByUserId() throws Exception {
        SubscriberEntity savedEntity = testEntityManager.persistFlushFind(new SubscriberEntity(1L));
        Optional<SubscriberEntity> retrievedEntity = repositoryUnderTest
                .findByUserId(savedEntity.getUserId());
        assertThat(savedEntity).isEqualTo(retrievedEntity.orElse(null));
    }

    @Test
    public void findByUserIdAndId() throws Exception {

    }

    @Test
    public void getSubscriberByCreatedAtIsAfter() throws Exception {

    }

    @Test
    public void getSubscriberByCreatedAtIsBefore() throws Exception {

    }

    @Test
    public void getSubscriberByUserId() throws Exception {
        SubscriberEntity savedEntity = testEntityManager.persistFlushFind(new SubscriberEntity(1L));
        Optional<SubscriberEntity> retrievedEntity = repositoryUnderTest
                .findByUserId(savedEntity.getUserId());
        assertThat(savedEntity).isEqualTo(retrievedEntity.orElse(null));

    }

}