package com.qbros.demo.service.entityDtoMapper;

import com.qbros.demo.controller.dto.BaseDTO;
import com.qbros.demo.persistence.JPA.entities.BaseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
public abstract class BaseEntityDtoMapper<E extends BaseEntity, D extends BaseDTO> {

    protected ModelMapper modelMapper;

    public BaseEntityDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public abstract D convertToDto(E entity);

    public abstract E convertToEntity(D dto);

    public List<D> convertToDtoList(List<E> listEntities) {
        List<D> dTOList = new ArrayList<>();
        for (E entity: listEntities){
            dTOList.add(convertToDto(entity));
        }
        return dTOList;
    }

    public Page<D> convertToDtoPage (Page<E> pageEntities, Pageable pageable){
        List<D> listDTOs = convertToDtoList(pageEntities.getContent());
        return new PageImpl<D>(listDTOs,pageable,pageEntities.getTotalPages());
    }

    public List<E> convertToEntityList(List<D> dtos) {
        List<E> entityList = new ArrayList<>();
        for (D dto: dtos){
            entityList.add(convertToEntity(dto));
        }
        return entityList;
    }
}
