package com.backend.service.resume.components.project;

import java.util.List;

import com.backend.service.resume.components.StringListDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Project {
	@Id
	@GeneratedValue
	private Long id;
	
	String title;
	String description;
	
	@ElementCollection
	List<String> bulletPoints;

	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getBulletPoints() {
		return bulletPoints;
	}

	public void setBulletPoints(List<String> bulletPoints) {
		this.bulletPoints = bulletPoints;
	}
	
	public Project() {
		super();
	}

	public Project(String title, String description, List<String> bulletPoints) {
		this.title = title;
		this.description = description;
		this.bulletPoints = bulletPoints;
	}
}
