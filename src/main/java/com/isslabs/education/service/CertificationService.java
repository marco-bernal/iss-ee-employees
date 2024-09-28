package com.isslabs.education.service;

import com.isslabs.education.dto.CertificationDto;
import com.isslabs.education.exception.NotFoundException;
import com.isslabs.education.mapper.CertificationMapper;
import com.isslabs.education.model.Certification;
import com.isslabs.education.repository.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CertificationService {

    private final CertificationRepository certificationRepository;
    private final CertificationMapper certificationMapper;

    public List<CertificationDto> getAll() {
        return certificationRepository.findAll()
                .stream()
                .map(certificationMapper::certification2certificationDto)
                .collect(toList());
    }

    //TODO: Reanalyze whether is better to throw an exception when there's no value
    public CertificationDto getById(UUID id) {
        Certification certification = certificationRepository.findById(id).get();
        return certificationMapper.certification2certificationDto(certification);
    }

    public CertificationDto create(CertificationDto certificationDto) {
        Certification certification = certificationMapper.certificationDto2certification(certificationDto);
        certificationRepository.saveAndFlush(certification);
        return certificationMapper.certification2certificationDto(certification);
    }

    public Certification get(UUID id) {
        return certificationRepository.findById(id).orElseThrow(() -> new NotFoundException("Certification not found"));
    }
}
