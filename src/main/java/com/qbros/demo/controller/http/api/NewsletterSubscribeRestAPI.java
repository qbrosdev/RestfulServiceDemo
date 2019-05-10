package com.qbros.demo.controller.http.api;

import com.qbros.demo.controller.dto.ServiceCallResultDTO;
import com.qbros.demo.controller.dto.SubscriberDTO;
import com.qbros.demo.controller.exceptions.BadParameterException;
import com.qbros.demo.service.entityDtoMapper.SubscriptionMapper;
import com.qbros.demo.service.interfaces.NewsletterSubscriptionService;
import com.qbros.demo.springstuff.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.qbros.demo.controller.http.Validation.*;
import static com.qbros.demo.controller.http.api.NewsletterSubscribeRestAPI.ROOT_URI;

@RestController
@Validated
@RequestMapping(value = ROOT_URI)
public class NewsletterSubscribeRestAPI extends AbstractAPI<SubscriberDTO> {

    public final static String ROOT_URI = "/newsletter/subscribers";
    private final static String REQ_PARAM_CREATED = "created";
    private final static String REQ_PARAM_CREATED_GREATER = "gt";
    private final static String REQ_PARAM_CREATED_LS = "ls";
    private final static String REQ_PARAM_USER = "userid";

    private NewsletterSubscriptionService newsletterSubscriptionService;
    //note: it is better to use our mappers in the FACADE but I skip that aat the moment
    private SubscriptionMapper subscriptionMapper;

    @Autowired
    public NewsletterSubscribeRestAPI(NewsletterSubscriptionService newsletterSubscriptionService,
                                      SubscriptionMapper subscriptionMapper) {
        this.newsletterSubscriptionService = newsletterSubscriptionService;
        this.subscriptionMapper = subscriptionMapper;
    }

    //----------Read
    //127.0.0.1:8080/newsletter/subscribers?created=gt:2018-08-09
    //127.0.0.1:8080/newsletter/subscribers?created=ls:2018-08-09
    //127.0.0.1:8080/newsletter/subscribers?userId=######
    //127.0.0.1:8080/newsletter/subscribers
    //127.0.0.1:8080/newsletter/subscribers/#

    @GetMapping
    public Page<SubscriberDTO> getByConstraintPaged(
            @RequestParam Map<String, String> allRequestParams,
            @Pattern(regexp = DATE_REGEX, message = DATE_INVALID_MSG)
            @RequestParam(name = REQ_PARAM_CREATED, required = false) String created,
            @Pattern(regexp = DIGIT_REGEX, message = USER_INVALID_MSG)
            @RequestParam(name = REQ_PARAM_USER, required = false) String userId,
            Pageable pageable) {
        validateAggregatedParameters(allRequestParams);
        return queryProperService(created, userId, pageable);
    }

    public Page<SubscriberDTO> getAllPaged(Pageable pageable) {
        return subscriptionMapper.convertToDtoPage(newsletterSubscriptionService.getAllPaged(pageable), pageable);
    }

    @Override
    public List<SubscriberDTO> getAll() {
        return null;
    }

    @GetMapping(value = "/{Id}")
    public SubscriberDTO getById(@PathVariable("Id") String id) {
        return subscriptionMapper.convertToDto(
                newsletterSubscriptionService
                        .findById(subscriptionMapper.convertDtoIdToEntityID(Long.valueOf(id))));
    }

    //----------Delete
    @DeleteMapping
    public ResponseEntity<ServiceCallResultDTO> deleteAll() {
        newsletterSubscriptionService.deleteAll();
        //delete ALL and other bulk operations, may take time so it is better to respond
        // with ServiceCallResult.PARTIAL_COMPLETE and assign it an specific taskId
        ServiceCallResultDTO serviceCallResultDTO = ServiceCallResultDTO.PARTIAL_COMPLETE(123);
        serviceCallResultDTO.setDescription("delete ALL and other bulk operations, may take time so it is better to " +
                "respond with ServiceCallResult.PARTIAL_COMPLETE and assign it an specific taskId Note that is task id is dummy (for demo purpose only)");
        return new ResponseEntity<>(serviceCallResultDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{Id}")
    public ResponseEntity<ServiceCallResultDTO> deleteByID(@PathVariable("Id") long id) {
        newsletterSubscriptionService.deleteById(subscriptionMapper.extractEntityIDFromDtoSubscriptionID(id));
        return new ResponseEntity<>(ServiceCallResultDTO.SUCCESS(), HttpStatus.NO_CONTENT);
    }

    //----------Create
    @PostMapping
    public ResponseEntity<ServiceCallResultDTO> createNew(@RequestBody SubscriberDTO subscriberDTO) {
        long resId = subscriptionMapper.convertEntityIdToDtoID(newsletterSubscriptionService
                .createNew(subscriptionMapper.convertToEntity(subscriberDTO)));
        return new ResponseEntity<>(ServiceCallResultDTO.CREATED(ROOT_URI + "/" + resId), HttpStatus.CREATED);
    }

    //----------Update
    @PutMapping
    public ResponseEntity<ServiceCallResultDTO> updateExisting(@RequestBody SubscriberDTO subscriberDTO) {
        newsletterSubscriptionService.updateExisting(subscriptionMapper.convertToEntity(subscriberDTO));
        return new ResponseEntity<>(ServiceCallResultDTO.SUCCESS(), HttpStatus.OK);
    }

    //----------All the rest operations
    @GetMapping(path = "/check/{taskId}")
    public ResponseEntity<ServiceCallResultDTO> checkTask(@PathVariable("taskId") int id) {
        newsletterSubscriptionService.checkTask(id);
        return new ResponseEntity<>(ServiceCallResultDTO.SUCCESS(), HttpStatus.OK);
    }

    @GetMapping(path = "/easteregg")
    public String easterEgg() {
        return "Hello from Mr.Q with LUVE :)))";
    }

    //----------private methods----------------------------------------------------------------------------------------
    private Page<SubscriberDTO> queryProperService(String created, String userId, Pageable pageable) {

        if (!Utils.isNull(created)) {
            Map<String, String> paramValue = paramValueMapGenerator(created);
            if (paramValue.containsKey(REQ_PARAM_CREATED_GREATER)) {
                Date startDate = Utils.convertToDate(paramValue.get(REQ_PARAM_CREATED_GREATER));
                return getAllAfterDatePaged(startDate, pageable);
            }

            if (paramValue.containsKey(REQ_PARAM_CREATED_LS)) {
                Date endDate = Utils.convertToDate(paramValue.get(REQ_PARAM_CREATED_LS));
                return getAllBeforeDatePaged(endDate, pageable);
            }

            return null;
        }

        if (!Utils.isNull(userId)) {
            return getUserIdSubscription(Long.valueOf(userId), pageable);
        }

        return getAllPaged(pageable);
    }

    private Page<SubscriberDTO> getUserIdSubscription(long userID, Pageable pageable) {
        return subscriptionMapper.convertToDtoPage(newsletterSubscriptionService.getSubscriptionForUserIdPaged(userID, pageable), pageable);
    }

    //this validation is not limited to this case, but it will be applied for all validations which involve several parameters from input all together
    private void validateAggregatedParameters(Map<String, String> allRequestParams) {
        if (!Utils.isNull(allRequestParams.get(REQ_PARAM_CREATED)) && !Utils.isNull(allRequestParams.get(REQ_PARAM_USER))) {
            throw new BadParameterException("Impossible constraint set :(");
        }
    }

    private Page<SubscriberDTO> getAllBeforeDatePaged(Date endDate, Pageable pageable) {
        return subscriptionMapper.convertToDtoPage(newsletterSubscriptionService.getAllSubscribedBeforePaged(endDate, pageable), pageable);
    }

    private Page<SubscriberDTO> getAllAfterDatePaged(Date startDate, Pageable pageable) {
        return subscriptionMapper.convertToDtoPage(newsletterSubscriptionService.getAllSubscribedAfterPaged(startDate, pageable), pageable);
    }
}
