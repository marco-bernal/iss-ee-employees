package com.isslabs.education.controller;

import com.isslabs.education.dto.CertificationDto;
import com.isslabs.education.service.CertificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@AllArgsConstructor
@RequestMapping("/certifications")
@CrossOrigin(origins = "http://localhost:4200",
             maxAge = 3600)
public class CertificationController {

    private final CertificationService certificationService;

    @GetMapping
    public List<CertificationDto> getAll() {
        List<CertificationDto> certifications = certificationService.getAll();
        certifications.forEach(CertificationController::addLinks);
        return certifications;
    }

    @GetMapping("/{id}")
    public CertificationDto getById(@PathVariable("id") UUID id) {
        CertificationDto certificationDto = certificationService.getById(id);
        addLinks(certificationDto);
        return certificationDto;
    }

    @PostMapping
    public CertificationDto create(@RequestBody CertificationDto certificationDto) {
        CertificationDto certification = certificationService.create(certificationDto);
        addLinks(certification);
        return certification;
    }

    private static void addLinks(CertificationDto certificationDto) {
        certificationDto.add(
                linkTo(methodOn(CertificationController.class).getById(certificationDto.getId())).withSelfRel()
        );
    }


}
