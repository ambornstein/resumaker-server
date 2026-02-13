package com.backend.service.account;

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

import com.backend.service.resume.Resume;
import com.backend.service.resume.ResumeService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	private Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ResumeService resumeService;
	
	@GetMapping
	public ResponseEntity<Object> getAllAccounts() {
		try {
			Iterable<Account> accounts = accountService.findAll();
			return new ResponseEntity<Object>(accounts, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> createAccount(@RequestBody Account account) {
		try {
			Account savedAccount = accountService.save(account);
			return new ResponseEntity<Object>(savedAccount, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getAccountById(@PathVariable Long id) {
		try {
			Account account = accountService.findById(id);
			if (account != null) {
				return new ResponseEntity<Object>(account, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{accountId}/resumes")
	public ResponseEntity<Object> getResumes(@PathVariable Long accountId) {
		try {
			List<Resume> resumes = accountService.findAllResumesById(accountId);
			if (resumes != null) {
				return new ResponseEntity<Object>(resumes, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/{accountId}/resumes")
	public ResponseEntity<Object> addResume(@PathVariable Long accountId, @RequestBody Resume resume) {
		try {
			Resume savedResume = resumeService.save(resume);
			Account account = accountService.addResume(accountId, savedResume);
			if (account != null) {
				return new ResponseEntity<Object>(account, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{accountId}/resumes/{resumeId}")
	public ResponseEntity<Object> removeResume(@PathVariable Long accountId, @PathVariable Long resumeId) {
		try {
			Account account = accountService.removeResume(accountId, resumeId);
			resumeService.deleteById(resumeId);
			if (account != null) {
				return new ResponseEntity<Object>(account, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
