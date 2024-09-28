package com.isslabs.education.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto extends RepresentationModel<EmployeeDto> {

    private UUID idEmployee;

    private String firstName;

    private String lastName;

    private BigDecimal salary;

    private Set<CertificationDto> certifications;

}
