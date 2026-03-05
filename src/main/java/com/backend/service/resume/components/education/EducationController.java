package com.backend.service.resume.components.education;

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
public class EducationController {
	
	@Autowired
	EducationService educationService;
	
	@Autowired
	AccountService accountService;
	
	private Logger logger = LoggerFactory.getLogger(EducationController.class);
	
	@PostMapping("/accounts/{accountId}/education")
	public ResponseEntity<Object> createEducation(@PathVariable Long accountId, @RequestBody Education education) {
		try {
			Education savedEducation = educationService.save(education);
			accountService.addEducation(accountId, savedEducation);
			
			return new ResponseEntity<Object>(savedEducation, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/education/{educationId}")
	public ResponseEntity<Object> updateEducation(@PathVariable Long educationId, @RequestBody Education education) {
		try {
			Education updatedEducation = educationService.updateById(educationId, education);
			
			return new ResponseEntity<Object>(updatedEducation, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/accounts/{accountId}/education/{educationId}")
	public ResponseEntity<Object> deleteEducation(@PathVariable Long accountId, @PathVariable Long educationId) {
		try {
			accountService.removeEducation(accountId, educationId);
			if (educationService.deleteById(educationId)) {
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
	
}