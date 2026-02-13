package com.backend.service.resume.components.education;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Education {
	@Id
	@GeneratedValue
	private Long id;

	String degree;
	String schoolName;
	String location;
	String startDate;
	
	@Column(nullable = true)
	String endDate;
	
	@Transient
	boolean current;
	
	public Long getId() {
		return id;
	}
	
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public boolean isCurrent() {
		return endDate != null;
	}

	public Education () {
		
	}

	public Education(String degree, String schoolName, String location, String startDate) {
		setDegree(degree);
		setSchoolName(schoolName);
		setLocation(location);
		setStartDate(startDate);
	}
	
	public Education(String degree, String schoolName, String location, String startDate, String endDate) {
		this(degree, schoolName, location, startDate);
		setEndDate(endDate);
	}

}
