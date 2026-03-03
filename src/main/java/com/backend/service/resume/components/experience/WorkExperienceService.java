package com.backend.service.resume.components.experience;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.service.resume.ResumeService;
import com.backend.service.resume.components.IEntryService;

@Service
public class WorkExperienceService implements IEntryService<WorkExperience>{

	@Autowired
	private WorkExperienceRepository workExperienceRepository;

	@Autowired
	private ResumeService resumeService;

	public WorkExperience save(WorkExperience project) {
		return workExperienceRepository.save(project);
	}

	public WorkExperience assignToResume(Long resumeId, Long experienceId) {
		WorkExperience experience = findById(experienceId);
		if (experience != null) {
			resumeService.addExperience(resumeId, experience);
			return experience;
		}
		return null;
	}

	public WorkExperience removeFromResume(Long resumeId, Long experienceId) {
		WorkExperience project = findById(experienceId);
		if (project != null) {
			resumeService.removeProject(resumeId, experienceId);
			return project;
		}
		return null;
		
	}

	public WorkExperience updateById(Long id, WorkExperience experience) {
		WorkExperience existingExperience = findById(id);
		if (existingExperience != null) {
			existingExperience.company = experience.company;
			existingExperience.title = experience.title;
			existingExperience.bulletPoints = experience.bulletPoints;
			existingExperience.startDate = experience.startDate;
			existingExperience.endDate = experience.endDate;

			return save(existingExperience);
		}
		return null;
	}

	public List<WorkExperience> findAll() {
		return (List<WorkExperience>) workExperienceRepository.findAll();
	}
	
	public WorkExperience findById(Long id) {
		return workExperienceRepository.findById(id).orElse(null);
	}

	public boolean deleteById(Long id) {
		if (findById(id) != null) {
			workExperienceRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
