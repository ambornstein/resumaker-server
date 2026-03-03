package com.backend.service.resume.components.education;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.service.resume.ResumeService;
import com.backend.service.resume.components.IEntryService;

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
		if (education != null) {
			resumeService.addEducation(resumeId, education);
			return education;
		}
		return null;
	}

	public Education removeFromResume(Long resumeId, Long educationId) {
		Education education = findById(educationId);
		if (education != null) {
			resumeService.removeEducation(resumeId, educationId);
			return education;
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
