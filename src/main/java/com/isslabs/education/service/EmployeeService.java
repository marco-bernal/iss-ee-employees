package com.isslabs.education.service;

import com.isslabs.education.dto.EmployeeDto;
import com.isslabs.education.exception.NotFoundException;
import com.isslabs.education.mapper.EmployeeMapper;
import com.isslabs.education.model.Certification;
import com.isslabs.education.model.Employee;
import com.isslabs.education.repository.CertificationRepository;
import com.isslabs.education.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final CertificationRepository certificationRepository;

    public List<EmployeeDto> findEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::employee2Dto)
                .collect(toList());
    }

    public EmployeeDto create(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.employeeDto2employee(employeeDto);
        employeeRepository.save(employee);
        return employeeMapper.employee2Dto(employee);
    }

    public EmployeeDto findEmployeeById(UUID employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new NotFoundException("Employee not found: " + employeeId));
        return employeeMapper.employee2Dto(employee);
    }

    public EmployeeDto findByDates(Instant startDate, Instant endDate) {
        return employeeRepository.findBetweenDates(startDate, endDate).orElseThrow(() ->
                new RuntimeException(String.format("No matches found for startDate %1$s and endDate %1$s", startDate.toString(), endDate.toString())));
    }

    public EmployeeDto assignCertifications(Set<UUID> certificationId, UUID employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new NotFoundException("Employee not found: " + employeeId));

        Employee finalEmployee = employee;
        certificationId.forEach(certId -> {
                                    Certification cert = certificationRepository.findById(certId).orElseThrow(
                                            () -> new NotFoundException("Certification not found: " + certId));
                                    finalEmployee.getCertifications().add(cert);
                                });

        employee = employeeRepository.save(finalEmployee);
        return employeeMapper.employee2Dto(employee);
    }
}
