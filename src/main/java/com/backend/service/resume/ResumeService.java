package com.backend.service.resume;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.service.resume.components.education.Education;
import com.backend.service.resume.components.experience.WorkExperience;
import com.backend.service.resume.components.project.Project;

@Service
public class ResumeService {

	@Autowired
	private ResumeRepository resumeRepository;
	
	public Resume save(Resume resume) {
		return resumeRepository.save(resume);
	}
	
	public List<Resume> findAll() {
		return resumeRepository.findAll();
	}
	
	public Resume findById(Long id) {
		return resumeRepository.findById(id).orElse(null);
	}
	
	public void deleteById(Long id) {
		resumeRepository.deleteById(id);
	}
	
	public Resume addExperience(Long resumeId, WorkExperience experience) {
		Resume resume = findById(resumeId);
		if (resume != null) {
			resume.addWorkExperience(experience);
			return save(resume);
		}
		return null;
	}
	
	public Resume removeExperience(Long resumeId, Long workId) {
		Resume resume = findById(resumeId);
		if (resume != null) {
			WorkExperience work = resume.getWorkHistory().stream().filter(w -> w.getId().equals(workId)).findFirst().orElse(null);
			if (work != null) {
				resume.removeWorkExperience(work);
				return save(resume);
			}
		}
		return null;
	}
	
	public Resume addEducation(Long resumeId, Education education) {
		Resume resume = findById(resumeId);
		if (resume != null) {
			resume.addEducation(education);
			return save(resume);
		}
		return null;
	}
	
	public Resume removeEducation(Long resumeId, Long educationId) {
		Resume resume = findById(resumeId);
		if (resume != null) {
			Education education = resume.getEducationHistory().stream().filter(e -> e.getId().equals(educationId)).findFirst().orElse(null);
			if (education != null) {
				resume.removeEducation(education);
				return save(resume);
			}
		}
		return null;
	}
	
	public Resume addProject(Long resumeId, Project project) {
		Resume resume = findById(resumeId);
		if (resume != null) {
			resume.addProject(project);
			return save(resume);
		}
		return null;
	}
	
	public Resume removeProject(Long resumeId, Long projectId) {
		Resume resume = findById(resumeId);
		if (resume != null) {
			Project project = resume.getProjects().stream().filter(p -> p.getId().equals(projectId)).findFirst().orElse(null);
			if (project != null) {
				resume.removeProject(project);
				return save(resume);
			}
		}
		return null;
	}
}
