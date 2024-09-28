package com.isslabs.education.mapper;

import com.isslabs.education.dto.EmployeeDto;
import com.isslabs.education.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "creationDate", expression = "java(java.time.Instant.now())")
    Employee employeeDto2employee(EmployeeDto employeeDto);

    @Mapping(target = "idEmployee" , source = "id")
    EmployeeDto employee2Dto(Employee employee);
}
