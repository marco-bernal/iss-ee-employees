package com.isslabs.education.mapper;

import com.isslabs.education.dto.CertificationDto;
import com.isslabs.education.model.Certification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CertificationMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "creationDate", expression = "java(java.time.Instant.now())")
    Certification certificationDto2certification(CertificationDto certificationDto);

    CertificationDto certification2certificationDto(Certification certification);
}
