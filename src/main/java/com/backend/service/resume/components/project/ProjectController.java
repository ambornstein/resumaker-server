package com.backend.service.resume.components.project;

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
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	AccountService accountService;
	
	private Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@PostMapping("/accounts/{accountId}/projects")
	public ResponseEntity<Object> createProject(@PathVariable Long accountId, @RequestBody Project project) {
		try {
			Project savedProject = projectService.save(project);
			accountService.addProject(accountId, savedProject);
			
			return new ResponseEntity<Object>(savedProject, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/projects/{projectId}")
	public ResponseEntity<Object> updateProject(@PathVariable Long projectId, @RequestBody Project project) {
		try {
			Project updatedProject = projectService.updateById(projectId, project);
			
			return new ResponseEntity<Object>(updatedProject, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/accounts/{accountId}/projects/{projectId}")
	public ResponseEntity<Object> deleteProject(@PathVariable Long accountId, @PathVariable Long projectId) {
		try {
			accountService.removeProject(accountId, projectId);
			if (projectService.deleteById(projectId)) {
			
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
	
	@PostMapping("/resumes/{resumeId}/projects/{projectId}")
	public ResponseEntity<Object> addProject(@PathVariable Long resumeId, @PathVariable Long projectId) {
		try {
			Project project = projectService.assignToResume(resumeId, projectId);
			
			return new ResponseEntity<Object>(project, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/resumes/{resumeId}/projects/{projectId}")
	public ResponseEntity<Object> removeProject(@PathVariable Long resumeId, @PathVariable Long projectId) {
		try {
			Project project = projectService.removeFromResume(resumeId, projectId);
			return new ResponseEntity<Object>(project, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
