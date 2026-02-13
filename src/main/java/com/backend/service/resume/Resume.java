package com.backend.service.resume;

import java.util.Set;

import com.backend.service.account.Account;
import com.backend.service.resume.components.education.Education;
import com.backend.service.resume.components.experience.WorkExperience;
import com.backend.service.resume.components.project.Project;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Resume {

	@Id
	@GeneratedValue
	private Long id;

	private String label;

	@ManyToMany
	@JoinTable(name = "work_entry", joinColumns = @JoinColumn(name = "resume_id"), inverseJoinColumns = @JoinColumn(name = "work_id"))
	private Set<WorkExperience> workHistory;
	
	@ManyToMany
	@JoinTable(name = "education_entry", joinColumns= @JoinColumn(name = "resume_id"), inverseJoinColumns = @JoinColumn(name = "education_id"))
	private Set<Education> educationHistory;

	@ManyToMany
	@JoinTable(name = "project_entry", joinColumns= @JoinColumn(name = "resume_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	private Set<Project> projects;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="account_id")
	private Account account;
	
	public Long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public Set<WorkExperience> getWorkHistory() {
		return workHistory;
	}

	public void addWorkExperience(WorkExperience workExperience) {
		workHistory.add(workExperience);
	}
	
	public void removeWorkExperience(WorkExperience workExperience) {
		workHistory.remove(workExperience);
	}

	public Set<Education> getEducationHistory() {
		return educationHistory;
	}

	public void addEducation(Education education) {
		educationHistory.add(education);
	}
	
	public void removeEducation(Education education) {
		educationHistory.remove(education);
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void addProject(Project project) {
		projects.add(project);
	}
	
	public void removeProject(Project project) {
		projects.remove(project);
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public Resume() {
	}

	public Resume(String label) {
		this.setLabel(label);
	}
}
