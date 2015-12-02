package org.sanelib.eboss.core.domain.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "sequence", sequenceName = "employee_id_seq")
@Table(name = "employee")
public class Employee extends BaseEntity {

	@Column(name = "employee_id")
	private Long empId;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "dateofbirth")
	private Timestamp dateOfBirth;

	@Column(name = "dateofjoining")
	private Timestamp dateOfJoining;

	public Employee() {
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Timestamp dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Timestamp getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Timestamp dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
}
