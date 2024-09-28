package com.isslabs.education.factory;

import com.isslabs.education.model.Certification;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static java.time.Instant.now;
import static java.util.UUID.randomUUID;

/**
 * Factory / Builder for Certification Testing
 */
@Setter
public class CertificationFactory {

    public static CertificationFactory certificationFactory() {
        return new CertificationFactory();
    }

//    public static Certification create(String name, String description) {
//        return Certification.builder()
//                .id(randomUUID())
//                .name(name)
//                .description(description)
//                .creationDate(now())
//                .build();
//    }
//
//    public static List<Certification> addCertifications(int number) {
//
//        ArrayList<Certification> certifications = new ArrayList<>();
//
//        Certification certification1 = create("Java 8 OCA","OCA");
//        Certification certification2 = create("Java 8 OPC","OCP");
//        Certification certification3 = create("Spring","Spring Framework");
//
//        switch(number) {
//            case 1: certifications.add(certification1); break;
//            case 2: certifications.add(certification1); certifications.add(certification2); break;
//            case 3: certifications.add(certification1); certifications.add(certification2);
//                certifications.add(certification3); break;
//        }
//
//        return certifications;
//    }
}
