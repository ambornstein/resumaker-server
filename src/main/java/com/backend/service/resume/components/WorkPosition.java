package com.backend.service.resume.components;

import java.util.List;
import java.util.Set;

import com.backend.service.resume.Resume;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class WorkPosition {
	
	@Id
	@GeneratedValue
	Long id;
	String title;
	String company;
	String startDate;
	String endDate;
	List<String> bulletPoints;
	
	@ManyToMany(mappedBy="workHistory")
	Set<Resume> includedResumes;
}
