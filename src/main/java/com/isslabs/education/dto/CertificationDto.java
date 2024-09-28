package com.isslabs.education.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificationDto extends RepresentationModel<CertificationDto> {

    private UUID id;

    private String name;

    private String description;
}
