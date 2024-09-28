package com.isslabs.education.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "certifications")
public class Employee {

	@Id
	@Column
	private UUID id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private BigDecimal salary;

	@Column
	private boolean inactive;

	@Column
	private Instant creationDate;

	@Column
	private Instant updateDate;

	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name = "employee_certification",
			   joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
			   inverseJoinColumns = {@JoinColumn(name = "certification_id", referencedColumnName = "id")})
	@JsonManagedReference
	private Set<Certification> certifications = new HashSet<>();


	public Employee(UUID id, String firstName, String lastName, BigDecimal salary,
					Instant creationDate, Instant updateDate, Set<Certification> certifications) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.certifications = certifications;
		this.certifications.forEach(cert -> cert.getEmployees().add(this));
	}
}
