package com.qbros.demo.service.interfaces;

import com.qbros.demo.persistence.JPA.entities.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
public interface BaseService<E extends BaseEntity> {

    String SERVICE_ERR_OPERATION_NOT_SUPPORTED = "Operation not supported";

    boolean checkTask(int taskID);

    E findById(long id);

    List<E> getAll();

    Page<E> getAllPaged(Pageable pageable);

    long createNew(E entity);

    void updateExisting(E entity);

    void deleteById(long id);

    void deleteAll();

}
