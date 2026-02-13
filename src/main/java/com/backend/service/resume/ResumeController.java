package com.backend.service.resume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.backend.service.account.AccountService;
import com.backend.service.resume.components.education.Education;
import com.backend.service.resume.components.education.EducationRepository;
import com.backend.service.resume.components.experience.WorkExperience;
import com.backend.service.resume.components.experience.WorkExperienceRepository;
import com.backend.service.resume.components.project.Project;
import com.backend.service.resume.components.project.ProjectRepository;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

	private Logger logger = LoggerFactory.getLogger(ResumeController.class);

	@Autowired
	private ResumeService resumeService;

	@Autowired
	private AccountService accountService;
	
	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	WorkExperienceRepository workExperienceRepository;

	@Autowired
	EducationRepository educationRepository;

	@GetMapping
	public ResponseEntity<Object> getAllResumes() {
		try {
			Iterable<Resume> resumes = resumeService.findAll();
			return new ResponseEntity<Object>(resumes, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getResumeById(@PathVariable Long id) {
		try {
			Resume resume = resumeService.findById(id);
			if (resume != null) {
				return new ResponseEntity<Object>(resume, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping
	public ResponseEntity<Object> createResume(@RequestBody Resume resume) {
		try {
			Resume savedResume = resumeService.save(resume);
			return new ResponseEntity<Object>(savedResume, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/{resumeId}/projects")
	public ResponseEntity<Object> createProject(@PathVariable Long resumeId, @RequestBody Project project) {
		try {
			Project savedProject = projectRepository.save(project);
			Resume resume = resumeService.addProject(resumeId, savedProject);
			accountService.addProject(resume.getAccount().getId(), savedProject);
			
			return new ResponseEntity<Object>(resume, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/{resumeId}/projects/{projectId}")
	public ResponseEntity<Object> addProject(@PathVariable Long resumeId, @PathVariable Long projectId) {
		try {
			Project currentProject = projectRepository.findById(projectId).orElse(null);
			Resume resume = resumeService.addProject(resumeId, currentProject);
			return new ResponseEntity<Object>(resume, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{resumeId}/projects/{projectId}")
	public ResponseEntity<Object> removeProject(@PathVariable Long resumeId, @PathVariable Long projectId) {
		try {
			Resume resume = resumeService.removeProject(resumeId, projectId);
			return new ResponseEntity<Object>(resume, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	

	@PostMapping("/{resumeId}/experience")
	public ResponseEntity<Object> createExperience(@PathVariable Long resumeId,
			@RequestBody WorkExperience experience) {
		try {
			WorkExperience savedExperience = workExperienceRepository.save(experience);
			Resume resume = resumeService.addExperience(resumeId, savedExperience);
			accountService.addWorkExperience(resume.getAccount().getId(), savedExperience);
			
			return new ResponseEntity<Object>(resume, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/{resumeId}/experience/{experienceId}")
	public ResponseEntity<Object> addExperience(@PathVariable Long resumeId, @PathVariable Long experienceId) {
		try {
			WorkExperience currentExperience = workExperienceRepository.findById(experienceId).orElse(null);
			Resume resume = resumeService.addExperience(resumeId, currentExperience);
			return new ResponseEntity<Object>(resume, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{resumeId}/experience/{experienceId}")
	public ResponseEntity<Object> removeExperience(@PathVariable Long resumeId, @PathVariable Long experienceId) {
		try {
			Resume resume = resumeService.removeExperience(resumeId, experienceId);
			return new ResponseEntity<Object>(resume, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/{resumeId}/education")
	public ResponseEntity<Object> createEducation(@PathVariable Long resumeId, @RequestBody Education education) {
		try {
			Education savedEducation = educationRepository.save(education);
			Resume resume = resumeService.addEducation(resumeId, savedEducation);
			accountService.addEducation(resume.getAccount().getId(), savedEducation);
			
			return new ResponseEntity<Object>(resume, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/{resumeId}/education/{educationId}")
	public ResponseEntity<Object> addEducation(@PathVariable Long resumeId, @PathVariable Long educationId) {
		try {
			Education currentEducation = educationRepository.findById(educationId).orElse(null);
			Resume resume = resumeService.addEducation(resumeId, currentEducation);
			return new ResponseEntity<Object>(resume, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{resumeId}/education/{educationId}")
	public ResponseEntity<Object> removeEducation(@PathVariable Long resumeId, @PathVariable Long educationId) {
		try {
			Resume resume = resumeService.removeEducation(resumeId, educationId);
			return new ResponseEntity<Object>(resume, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
