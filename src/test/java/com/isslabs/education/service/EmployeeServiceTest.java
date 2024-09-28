package com.isslabs.education.service;

import com.isslabs.education.model.Certification;
import com.isslabs.education.model.Employee;
import com.isslabs.education.repository.CertificationRepository;
import com.isslabs.education.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

//import static com.isslabs.education.factory.CertificationFactory.addCertifications;
import static com.isslabs.education.factory.EmployeeFactory.employeeFactory;
//import static com.isslabs.education.factory.CertificationFactory.create;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceTest {

//    @Mock
//    private EmployeeRepository mockedEmployeeRepository;
//
//    @InjectMocks
//    private EmployeeService mockedEmployeeService;
//
//    private Employee employee1;
    @Autowired
    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    private CertificationRepository certificationRepository;


    @BeforeEach
    public void setUp() {
//        employee1 = employeeFactory().create("Joan","Williams", 7500);
    }

//    @Test
//    public void mustAssignCertificationsToEmployee() {
        //given

        //when FIXME:Update test once DTOs are added
//        when(mockedEmployeeRepository.save(employee1)).thenReturn(employee1);
//        when(mockedEmployeeRepository.getOne(any(UUID.class))).thenReturn(employee1);
//
//        Employee employeeResult = mockedEmployeeService.assignCertification(employee1, addCertifications(2));
//
//        //then
//        assertThat(employeeResult.getId()).isEqualTo(employee1.getId());
//        assertThat(employeeResult.getFirstName()).isEqualTo(employee1.getFirstName());
//        assertThat(employeeResult.getLastName()).isEqualTo(employee1.getLastName());
//
//        assertThat(employeeResult.getCertifications()).hasSize(2);
//        assertThat(employeeResult.getCertifications())
//                .extracting(Certification::getName)
//                .containsExactly(employee1.getCertifications().get(0).getName(),
//                                 employee1.getCertifications().get(1).getName());
//    }

//    @Test
//    private void basicManualTest() {
//
//        Employee employee1 = employeeFactory().create("Joan","Williams", 7500);
//
//        Certification certification1 = create("Java 8 OPC","OCP");
//        Certification certification2 = create("Spring","Spring Framework");
//
//        //Add certification references in the employee
//        employee1.getCertifications().add(certification1);
//        employee1.getCertifications().add(certification2);
//
//        //Add employee reference in the certifications
//        certification1.getEmployees().add(employee1);
//        certification2.getEmployees().add(employee1);
//
//        employeeRepository.save(employee1);
//
//    }




}


