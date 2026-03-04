package com.backend.service.resume.components.experience;

import java.util.List;
import java.util.Set;
import com.backend.service.resume.Resume;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;

@Entity
public class WorkExperience {

	@Id
	@GeneratedValue
	Long id;
	
	String title;
	
	String company;
	
	String startDate;
	
	@Column(nullable = true)
	String endDate;
	
	@Transient
	boolean current;
	
	@ElementCollection
	List<String> bulletPoints;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "work_entry", joinColumns = @JoinColumn(name = "resume_id"), inverseJoinColumns = @JoinColumn(name = "work_id"))
	Set<Resume> resumes;
	
	
	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public List<String> getBulletPoints() {
		return bulletPoints;
	}

	public void setBulletPoints(List<String> bulletPoints) {
		this.bulletPoints = bulletPoints;
	}
	
	public boolean isCurrent() {
		return endDate != null;
	}


	public WorkExperience() {
		super();
	}

	public WorkExperience(String title, String company, String startDate, List<String> bulletPoints) {
		setTitle(title);
		setCompany(company);
		setStartDate(startDate);
		setBulletPoints(bulletPoints);
	}
	
	public WorkExperience(String title, String company, String startDate, String endDate, List<String> bulletPoints) {
		this(title, company, startDate, bulletPoints);
		setEndDate(endDate);
	}
}
