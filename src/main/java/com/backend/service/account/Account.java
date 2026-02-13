package com.backend.service.account;

import java.util.List;
import java.util.Set;

import com.backend.service.resume.Resume;
import com.backend.service.resume.components.education.Education;
import com.backend.service.resume.components.experience.WorkExperience;
import com.backend.service.resume.components.project.Project;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;

	private String lastName;

	@OneToMany(mappedBy = "account")
	@JsonManagedReference
	private List<Resume> resumes;

	@OneToMany
	private Set<WorkExperience> workExperiences;
	
	@OneToMany
	private Set<Education> educationEntries;
	
	@OneToMany
	private Set<Project> projects;
	
	public Long getId() {
		return id;
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
	
	
	public void addResume(Resume resume) {
		resumes.add(resume);
		resume.setAccount(this);
	}
	
	public void removeResume(Resume resume) {
		resumes.remove(resume);
		resume.setAccount(null);
	}
	
	public List<Resume> getResumes() {
		return resumes;
	}
	
	public void addWorkExperience(WorkExperience work) {
		workExperiences.add(work);
	}
	
	public void removeWorkExperience(WorkExperience work) {
		workExperiences.remove(work);
	}
	
	public Set<WorkExperience> getWorkExperiences() {
		return workExperiences;
	}
	
	public void addEducation(Education education) {
		educationEntries.add(education);
	}
	
	public void removeEducation(Education education) {
		educationEntries.remove(education);
	}
	
	public Set<Education> getEducationEntries() {
		return educationEntries;
	}

	public void addProject(Project project) {
		projects.add(project);
	}
	
	public void removeProject(Education project) {
		educationEntries.remove(project);
	}
	
	public Set<Project> getProjects() {
		return projects;
	}
	
	public Account() {
	}

	public Account(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

}