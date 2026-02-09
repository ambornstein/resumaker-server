package com.backend.service.account;

import java.util.Set;

import com.backend.service.resume.Resume;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}
	
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	private String lastName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToMany(mappedBy = "account")
	private Set<Resume> resumes;

	public void addResume(Resume resume) {
		resumes.add(resume);
	}
	
	public void removeResume(Resume resume) {
		resumes.remove(resume);
	}
	
	public Set<Resume> getResumes() {
		return resumes;
	}
	
	public Account() {
	}

	public Account(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

}