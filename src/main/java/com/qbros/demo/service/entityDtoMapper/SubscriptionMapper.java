package com.qbros.demo.service.entityDtoMapper;

import com.qbros.demo.controller.dto.SubscriberDTO;
import com.qbros.demo.persistence.JPA.entities.SubscriberEntity;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

public class SubscriptionMapper extends BaseEntityDtoMapper<SubscriberEntity, SubscriberDTO> {

    @Autowired
    public SubscriptionMapper(ModelMapper modelMapper) {
        super(modelMapper);

        Converter<Long, Long> dtoIdToEntityIdConverter = new AbstractConverter<Long, Long>() {
            protected Long convert(Long source) {
                return source == null ? null : source - 1000;
            }
        };

        Converter<Long, Long> entityIdToDtoIdConverter = new AbstractConverter<Long, Long>() {
            protected Long convert(Long source) {
                return source == null ? null : source + 1000;
            }
        };

        this.modelMapper.addMappings(new PropertyMap<SubscriberDTO, SubscriberEntity>() {
            @Override
            protected void configure() {
                using(dtoIdToEntityIdConverter).map().setId(source.getSubscriptionId());
            }
        });
        this.modelMapper.addMappings(new PropertyMap<SubscriberEntity, SubscriberDTO>() {
            @Override
            protected void configure() {
                using(entityIdToDtoIdConverter).map().setSubscriptionId(source.getId());
            }
        });

    }


    //we don't want to expose the actual IDs of our entities
    @Override
    public SubscriberDTO convertToDto(SubscriberEntity entity) {
        return modelMapper.map(entity, SubscriberDTO.class);
    }

    @Override
    public SubscriberEntity convertToEntity(SubscriberDTO dto) {
        return modelMapper.map(dto, SubscriberEntity.class);
    }

    public long extractEntityIDFromDtoSubscriptionID(long subscriptionID) {
        return subscriptionID - 1000;
    }

    public long convertEntityIdToDtoID(long entityId) {
        return entityId + 1000;
    }

    public long convertDtoIdToEntityID(long dtoId) {
        return dtoId - 1000;
    }
}
