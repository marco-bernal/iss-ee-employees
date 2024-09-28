package com.isslabs.education.projections;

import java.math.BigDecimal;
import java.util.UUID;

public interface EmployeeProjection {

    UUID getId();
    String getFirstName();
    String getLastName();
    BigDecimal getSalary();
}