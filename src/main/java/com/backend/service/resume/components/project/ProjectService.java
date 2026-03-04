package com.backend.service.resume.components.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.service.resume.Resume;
import com.backend.service.resume.ResumeService;
import com.backend.service.resume.components.IEntryService;

@Service
public class ProjectService implements IEntryService<Project> {
	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ResumeService resumeService;

	public Project save(Project project) {
		return projectRepository.save(project);
	}

	public Project assignToResume(Long resumeId, Long projectId) {
		Project project = findById(projectId);
		Resume resume = resumeService.findById(resumeId);
		if (project != null && resume != null) {
			project.resumes.add(resume);
			return save(project);
		}
		return null;
	}

	public Project removeFromResume(Long resumeId, Long projectId) {
		Project project = findById(projectId);
		Resume resume = resumeService.findById(resumeId);
		if (project != null && resume != null) {
			project.resumes.remove(resume);
			return save(project);
		}
		return null;
		
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
