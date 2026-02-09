package com.backend.service.resume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class ResumeController {
	private Logger logger = LoggerFactory.getLogger(ResumeController.class);

	@Autowired
	private ResumeService resumeService;

	@GetMapping("/resumes")
	public ResponseEntity<Object> getAllResumes() {
		try {
			Iterable<Resume> resumes = resumeService.findAll();
			return new ResponseEntity<Object>(resumes, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/resumes/{id}")
	public ResponseEntity<Object> getResumeById(@PathVariable("id") Long id) {
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
	
	@PostMapping("/resumes")
	public ResponseEntity<Object> createResume(@RequestBody Resume resume) {
		try {
			Resume savedResume = resumeService.save(resume);
			return new ResponseEntity<Object>(savedResume, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
