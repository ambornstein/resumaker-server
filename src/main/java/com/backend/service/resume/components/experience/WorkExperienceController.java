package com.backend.service.resume.components.experience;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.service.account.AccountService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class WorkExperienceController {
	
	@Autowired
	WorkExperienceService experienceService;
	
	@Autowired
	AccountService accountService;
	
	private Logger logger = LoggerFactory.getLogger(WorkExperienceController.class);
	
	@PostMapping("/accounts/{accountId}/experience")
	public ResponseEntity<Object> createExperience(@PathVariable Long accountId, @RequestBody WorkExperience experience) {
		try {
			WorkExperience savedExperience = experienceService.save(experience);
			accountService.addWorkExperience(accountId, savedExperience);
			
			return new ResponseEntity<Object>(savedExperience, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/experience/{experienceId}")
	public ResponseEntity<Object> updateExperience(@PathVariable Long experienceId, @RequestBody WorkExperience experience) {
		try {
			WorkExperience updatedExperience = experienceService.updateById(experienceId, experience);
			
			return new ResponseEntity<Object>(updatedExperience, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/accounts/{accountId}/experience/{experienceId}")
	public ResponseEntity<Object> deleteExperience(@PathVariable Long accountId, @PathVariable Long experienceId) {
		try {
			accountService.removeWorkExperince(accountId, experienceId);
			if (experienceService.deleteById(experienceId)) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/resumes/{resumeId}/experience/{experienceId}")
	public ResponseEntity<Object> addExperience(@PathVariable Long resumeId, @PathVariable Long experienceId) {
		try {
			WorkExperience experience = experienceService.assignToResume(resumeId, experienceId);
			
			return new ResponseEntity<Object>(experience, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/resumes/{resumeId}/experience/{experienceId}")
	public ResponseEntity<Object> removeExperience(@PathVariable Long resumeId, @PathVariable Long experienceId) {
		try {
			WorkExperience experience = experienceService.removeFromResume(resumeId, experienceId);
			return new ResponseEntity<Object>(experience, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
