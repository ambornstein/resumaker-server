package com.backend.service.resume;

import java.util.Set;

import com.backend.service.account.Account;
import com.backend.service.resume.components.WorkPosition;
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

	public Resume() {
	}

	public Resume(String label) {
		this.setLabel(label);
	}

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="account_id")
	private Account account;
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}

	@ManyToMany
	@JoinTable(name = "work_positions", joinColumns = @JoinColumn(name = "resume_id"), inverseJoinColumns = @JoinColumn(name = "work_id"))
	private Set<WorkPosition> workHistory;
//
//	@ManyToMany
//	private Set<Education> educationHistory;
//
//	@ManyToMany
//	private Set<Project> projects;

}
