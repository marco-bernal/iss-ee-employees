package com.isslabs.education.controller;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.isslabs.education.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import com.isslabs.education.service.EmployeeService;

import static java.time.LocalDateTime.parse;
import static java.time.ZoneId.systemDefault;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200",
             maxAge = 3600) //TODO: Do it in a config class and web level
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> retrieveAll() {
        List<EmployeeDto> employees = employeeService.findEmployees();
        employees.forEach(EmployeeController::addLinks);
        return employees;
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") UUID id) {
        EmployeeDto employeeDto = employeeService.findEmployeeById(id);
        addLinks(employeeDto);
        return employeeDto;
    }

    @PostMapping
    public EmployeeDto create(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployeeDto = employeeService.create(employeeDto);
        addLinks(savedEmployeeDto);
        return savedEmployeeDto;
    }

    // TODO: Fix method, does not work
    @GetMapping("/byDates")
    public EmployeeDto getByDates(@RequestParam("startDate") String startDate,
                                  @RequestParam("endDate") String endDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss")
                .withZone(systemDefault());

        EmployeeDto employeeDto = employeeService.findByDates(parse(startDate, formatter).toInstant(ZoneOffset.UTC)
                , parse(endDate, formatter).toInstant(ZoneOffset.UTC));

        addLinks(employeeDto);
        return employeeDto;
    }

    @PostMapping("/assign/{id}")
    public EmployeeDto assignCertifications(@PathVariable("id") UUID id, @RequestBody Set<UUID> certificationId) {
        return employeeService.assignCertifications(certificationId, id);
    }

    //TODO: Extend links for update and delete, using HATEOAS best practices
    private static void addLinks(EmployeeDto employeeDto) {
        employeeDto.add(
                linkTo(methodOn(EmployeeController.class).getEmployeeById(employeeDto.getIdEmployee()))
                        .withSelfRel());
    }

    //TODO: Add pagination method, try to make it generic

}
