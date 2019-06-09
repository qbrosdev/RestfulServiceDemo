//package com.qbros.demo.controller.http.api;
//
//import com.qbros.demo.controller.dto.SubscriberDTO;
//import com.qbros.demo.service.entityDtoMapper.SubscriptionMapper;
//import com.qbros.demo.service.interfaces.NewsletterSubscriptionService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.validation.constraints.Pattern;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.Map;
//
//import static com.qbros.demo.controller.http.Validation.*;
//import static org.junit.Assert.*;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//
//
//
///**
// * Created by QBros on Zero Hour ... Hooah!
// */
//@RunWith(SpringRunner.class)
//@WebMvcTest(NewsletterSubscribeRestAPI.class)
//public class NewsletterSubscribeRestAPITest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private NewsletterSubscriptionService newsletterSubscriptionService;
//
//    @MockBean
//    private SubscriptionMapper subscriptionMapper;
//
//    @Autowired
//    private NewsletterSubscribeRestAPI restAPIUnderTest;
//
//    @Test
//    public Page<SubscriberDTO> get_created_after() {
//        SubscriberDTO.builder().subscriptionId().build();
//
//        given(subscriptionMapper.convertToDtoPage(newsletterSubscriptionService
//                .getAllSubscribedAfterPaged(new Date(), PageImpl()), pageable).willReturn(allEmployees));
//
//        mockMvc.perform(get("/api/employees")
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].name", is(alex.getName()));
//    }
//
//    @Test
//    public Page<SubscriberDTO> getByConstraintPaged_created_before() {
//        Employee alex = new Employee("alex");
//
//        List<Employee> allEmployees = Arrays.asList(alex);
//
//        given(newsletterSubscriptionService.getAllEmployees()).willReturn(allEmployees);
//
//        mvc.perform(get("/api/employees")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].name", is(alex.getName())));
//    }
//
//    @Test
//    public void getAllPaged() throws Exception {
//        given(newsletterSubscriptionService.getAllPaged()).willReturn();
//
//
//        mockMvc.perform(get(""))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("").value(""));
//    }
//
//    @Test
//    public void getAll() throws Exception {
//
//    }
//
//    @Test
//    public void getById_availableId() throws Exception {
//
//    }
//
//    @Test
//    public void getById_notFoundId() throws Exception {
//        given(newsletterSubscriptionService.findById()).willThrow(new )
//
//        mockMvc.perform(MockMvcRequestBuilders.get(""))
//                .andExpect(status().isNotFound())
//    }
//
//    @Test
//    public void deleteAll() throws Exception {
//
//    }
//
//    @Test
//    public void deleteByID() throws Exception {
//
//    }
//
//    @Test
//    public void deleteByID_notFoundId() throws Exception {
//
//    }
//
//    @Test
//    public void createNew() throws Exception {
//
//    }
//
//    @Test
//    public void updateExisting() throws Exception {
//
//    }
//
//    @Test
//    public void checkTask() throws Exception {
//
//    }
//
//}