package com.backend.service.resume.components.experience;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.service.resume.Resume;
import com.backend.service.resume.ResumeService;
import com.backend.service.resume.components.IEntryService;
import com.backend.service.resume.components.project.Project;

@Service
public class WorkExperienceService {

	@Autowired
	private WorkExperienceRepository workExperienceRepository;

	public WorkExperience save(WorkExperience project) {
		return workExperienceRepository.save(project);
	}

	public WorkExperience updateById(Long id, WorkExperience experience) {
		WorkExperience existingExperience = findById(id);
		if (existingExperience != null) {
			existingExperience.company = experience.company;
			existingExperience.title = experience.title;
			existingExperience.bulletPoints = experience.bulletPoints;
			existingExperience.startDate = experience.startDate;
			existingExperience.endDate = experience.endDate;
			existingExperience.location = experience.location;

			return save(existingExperience);
		}
		return null;
	}

	public WorkExperience addToResume(Resume resume, WorkExperience experience) {
		experience.resumes.add(resume);
		return save(experience);
	}
	
	public WorkExperience removeFromResume(Resume resume, WorkExperience experience) {
		experience.resumes.remove(resume);
		return save(experience);
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
