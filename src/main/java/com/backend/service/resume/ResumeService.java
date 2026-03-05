package com.backend.service.resume;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.service.account.AccountService;
import com.backend.service.resume.components.education.Education;
import com.backend.service.resume.components.education.EducationService;
import com.backend.service.resume.components.experience.WorkExperience;
import com.backend.service.resume.components.experience.WorkExperienceService;
import com.backend.service.resume.components.project.Project;
import com.backend.service.resume.components.project.ProjectService;

@Service
public class ResumeService {

	@Autowired
	private ResumeRepository resumeRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired 
	private WorkExperienceService workExperienceService;
	
	@Autowired
	private EducationService educationService;
	
	@Autowired
	private ProjectService projectService;
	
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
	
	public Resume updateLinkedEducation(Long resumeId, Set<Long> educationIds) {
		Resume resume = findById(resumeId);
		if (resume != null) {
			for (Education education : accountService.getEducationById(resume.getAccount().getId())) {
				if (educationIds.contains(education.getId())) {
					educationService.addToResume(resume, education);
				}
				else {
					educationService.removeFromResume(resume, education);
				}
			}
			return save(resume);
		}
		return null;
	}
	
	public Resume updateLinkedWorkExperience(Long resumeId, Set<Long> experienceIds) {
		Resume resume = findById(resumeId);
		if (resume != null) {
			for (WorkExperience work : accountService.getWorkExperiencesById(resume.getAccount().getId())) {
				if (experienceIds.contains(work.getId())) {
					workExperienceService.addToResume(resume, work);
				}
				else {
					workExperienceService.removeFromResume(resume, work);
				}
			}
			return save(resume);
		}
		return null;
	}
	
	public Resume updateLinkedProjects(Long resumeId, Set<Long> projectIds) {
		Resume resume = findById(resumeId);
		if (resume != null) {
			for (Project project : accountService.getProjectsById(resume.getAccount().getId())) {
				if (projectIds.contains(project.getId())) {
					projectService.addToResume(resume, project);
				}
				else {
					projectService.removeFromResume(resume, project);
				}
			}
			return save(resume);
		}
		return null;
	}
}
