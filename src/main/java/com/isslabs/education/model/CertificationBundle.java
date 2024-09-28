package com.isslabs.education.model;

import lombok.Data;
import java.util.Set;
import java.util.UUID;

@Data
public class CertificationBundle {

    private UUID employeeId;
//    private Set<UUID> certificationIds;
    private Set<Certification> certifications;
}
