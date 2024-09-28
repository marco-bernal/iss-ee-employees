package com.isslabs.education.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Certification {

    @Id
    private UUID id;
    private String name;
    private String description;
    private boolean inactive;
    private Instant creationDate;
    private Instant updateDate;

    @ManyToMany(mappedBy = "certifications",
                cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonBackReference
    private Set<Employee> employees = new HashSet<>();

    public Certification(UUID id, String name, String description, Instant creationDate,
                         Instant updateDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }
}
