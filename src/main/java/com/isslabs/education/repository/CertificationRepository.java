package com.isslabs.education.repository;

import com.isslabs.education.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CertificationRepository extends JpaRepository<Certification, UUID> {


}
