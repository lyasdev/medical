package com.lyaslim.medical.commons.api.mappers;

import com.lyaslim.medical.commons.api.dtos.DtoToEntityMapper;

public interface CommonMapper<E,D extends DtoToEntityMapper<E>> {
    D toDto(E entity);
}
