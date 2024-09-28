package com.isslabs.education.factory;

import com.isslabs.education.model.Employee;
import lombok.Setter;

import java.math.BigDecimal;

import static java.time.Instant.now;
import static java.util.UUID.randomUUID;

/**
 * Factory / Builder for Employee testing
 */
@Setter
public class EmployeeFactory {

    public static EmployeeFactory employeeFactory(){
        return new EmployeeFactory();
    }

//    public static Employee create(String firstName, String lastName, int salary) {
//        return Employee.builder()
//                .id(randomUUID())
//                .firstName(firstName)
//                .lastName(lastName)
//                .salary(BigDecimal.valueOf(salary))
//                .creationDate(now())
//                .build();
//    }
}
