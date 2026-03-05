package com.backend.service.resume.components.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.service.resume.Resume;
import com.backend.service.resume.ResumeService;
import com.backend.service.resume.components.IEntryService;
import com.backend.service.resume.components.experience.WorkExperience;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;

	public Project save(Project project) {
		return projectRepository.save(project);
	}

	public Project updateById(Long id, Project project) {
		Project existingProject = findById(id);
		if (existingProject != null) {
			existingProject.bulletPoints = project.bulletPoints;
			existingProject.description = project.description;
			existingProject.title = project.title;

			return save(existingProject);
		}
		return null;
	}
	
	public Project addToResume(Resume resume, Project project) {
		project.resumes.add(resume);
		return save(project);
	}
	
	public Project removeFromResume(Resume resume, Project project) {
		project.resumes.remove(resume);
		return save(project);
	}
	

	public List<Project> findAll() {
		return (List<Project>) projectRepository.findAll();
	}

	public Project findById(Long id) {
		return projectRepository.findById(id).orElse(null);
	}

	public boolean deleteById(Long id) {
		if (findById(id) != null) {
			projectRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
