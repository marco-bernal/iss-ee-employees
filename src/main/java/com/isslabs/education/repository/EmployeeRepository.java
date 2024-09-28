/**
 *  Repository Method Definition for Employee Microservice
 */
package com.isslabs.education.repository;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import com.isslabs.education.dto.EmployeeDto;
import com.isslabs.education.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    //FIXME: NOT Reliable, returns inaccurate results
    @Query("select new com.isslabs.education.dto.EmployeeDto(e.id, e.firstName, e.lastName, e.salary, e.certifications) " +
            "from Employee  e " +
            "where e.creationDate >= :startDate " +
            "and e.creationDate <= :endDate"
    )
    Optional<EmployeeDto> findBetweenDates(@Param("startDate") Instant startDate, @Param("endDate") Instant endDate );
}
