package com.backend.service.resume.components.education;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.service.resume.Resume;
import com.backend.service.resume.ResumeService;
import com.backend.service.resume.components.IEntryService;
import com.backend.service.resume.components.experience.WorkExperience;

@Service
public class EducationService implements IEntryService<Education> {
	@Autowired
	private EducationRepository educationRepository;

	@Autowired
	private ResumeService resumeService;

	public Education save(Education education) {
		return educationRepository.save(education);
	}

	public Education assignToResume(Long resumeId, Long educationId) {
		Education education = findById(educationId);
		Resume resume = resumeService.findById(resumeId);
		if (education != null && resume != null) {
			education.resumes.add(resume);
			return save(education);
		}
		return null;
	}

	public Education removeFromResume(Long resumeId, Long educationId) {
		Education education = findById(educationId);
		Resume resume = resumeService.findById(resumeId);
		if (education != null && resume != null) {
			education.resumes.remove(resume);
			return save(education);
		}
		return null;
	}

	public Education updateById(Long id, Education education) {
		Education existingEducation = findById(id);
		if (existingEducation != null) {
			existingEducation.schoolName = education.schoolName;
			existingEducation.degree = education.degree;
			existingEducation.location = education.location;
			existingEducation.startDate = education.startDate;
			existingEducation.endDate = education.endDate;

			return save(existingEducation);
		}
		return null;
	}

	public List<Education> findAll() {
		return (List<Education>) educationRepository.findAll();
	}

	public Education findById(Long id) {
		return educationRepository.findById(id).orElse(null);
	}

	public boolean deleteById(Long id) {
		if (findById(id) != null) {
			educationRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}
