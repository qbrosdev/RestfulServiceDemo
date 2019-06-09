package com.qbros.IntegrationTESTS;

import com.qbros.demo.controller.dto.ServiceCallResultDTO;
import com.qbros.demo.controller.dto.SubscriberDTO;
import com.qbros.demo.controller.http.api.NewsletterSubscribeRestAPI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SystemTest {

    @Autowired
    NewsletterSubscribeRestAPI newsletterSubscribeRestAPI;

//    @Test
//    public void newSubscribe(){
//        ResponseEntity<ServiceCallResultDTO> responseEntity = newsletterSubscribeRestAPI
//                .createNew(new SubscriberDTO());
//        assertThat(responseEntity.getBody()).isEqualTo();
//    }
}
