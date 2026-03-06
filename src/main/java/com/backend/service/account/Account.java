package com.backend.service.account;

import java.util.List;
import java.util.Set;

import com.backend.service.resume.Resume;
import com.backend.service.resume.components.education.Education;
import com.backend.service.resume.components.experience.WorkExperience;
import com.backend.service.resume.components.project.Project;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;

	private String lastName;
	
	private String location;
	
	private boolean USCitizen;
	
	private String email;
	
	private String phoneNumber;
	
	private String website;
	
	private String linkedInLink;
	
	private String githubLink;

	@OneToMany(mappedBy = "account")
	@JsonManagedReference
	private Set<Resume> resumes;

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
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean getUSCitizen() {
		return USCitizen;
	}

	public void setUSCitizen(boolean isUSCitizen) {
		this.USCitizen = isUSCitizen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLinkedInLink() {
		return linkedInLink;
	}

	public void setLinkedInLink(String linkedInLink) {
		this.linkedInLink = linkedInLink;
	}
	
	public String getGithubLink() {
		return githubLink;
	}

	public void setGithubLink(String githubLink) {
		this.githubLink = githubLink;
	}

	public void addResume(Resume resume) {
		resumes.add(resume);
		resume.setAccount(this);
	}
	
	public void removeResume(Resume resume) {
		resumes.remove(resume);
		resume.setAccount(null);
	}
	
	public Set<Resume> getResumes() {
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
	
	public void removeProject(Project project) {
		projects.remove(project);
	}
	
	public Set<Project> getProjects() {
		return projects;
	}
	
	public Account() {
	}

	public Account(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
		setUSCitizen(false);
	}

}