package com.qbros.demo.controller.http.api;

import com.qbros.demo.controller.dto.BaseDTO;
import com.qbros.demo.controller.dto.ServiceCallResultDTO;
import com.qbros.demo.controller.http.Validation;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
public abstract class AbstractAPI<D extends BaseDTO> {

    protected final static String REQ_PARAM_SPLITTER = ":";

    public abstract List<D> getAll();

    public abstract D getById(@Pattern(regexp = Validation.DIGIT_REGEX, message = Validation.RESOURCE_INVALID_ID) @NotNull String id);

    public abstract ResponseEntity<ServiceCallResultDTO> deleteAll();

    public abstract ResponseEntity<ServiceCallResultDTO> deleteByID(@NotNull long id);

    public abstract ResponseEntity<ServiceCallResultDTO> createNew(@Valid D receivedDTO);

    public abstract ResponseEntity<ServiceCallResultDTO> updateExisting(@Valid D receivedDTO);

    public abstract ResponseEntity<ServiceCallResultDTO> checkTask(@NotNull int taskId);

    protected Map<String, String> paramValueMapGenerator(String input) {
        Map<String, String> resultMap = new HashMap<>();
        String[] strings = input.split(REQ_PARAM_SPLITTER);
        resultMap.put(strings[0], strings[1]);
        return resultMap;
    }

}
