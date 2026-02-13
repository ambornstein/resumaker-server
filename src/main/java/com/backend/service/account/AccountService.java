package com.backend.service.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.service.resume.Resume;
import com.backend.service.resume.components.education.Education;
import com.backend.service.resume.components.experience.WorkExperience;
import com.backend.service.resume.components.project.Project;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	public Account save(Account account) {
		return accountRepository.save(account);
	}

	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public Account findById(Long id) {
		return accountRepository.findById(id).orElse(null);
	}

	public List<Resume> findAllResumesById(Long id) {
		return accountRepository.findById(id).get().getResumes();
	}
	
	public void deleteById(Long id) {
		accountRepository.deleteById(id);
	}

	public Account addResume(Long accountId, Resume resume) {
		Account account = findById(accountId);
		if (account != null) {
			account.addResume(resume);
			return save(account);
		}
		return null;
	}

	public Account removeResume(Long accountId, Long resumeId) {
		Account account = findById(accountId);
		if (account != null) {
			Resume resume = account.getResumes().stream().filter(r -> r.getId().equals(resumeId)).findFirst()
					.orElse(null);
			if (resume != null) {
				account.removeResume(resume);
				return save(account);
			}
		}
		return null;
	}
	
	public Account addWorkExperience(Long accountId, WorkExperience work) {
		Account account = findById(accountId);
		if (account != null) {
			account.addWorkExperience(work);
			return save(account);
		}
		return null;
	}
	
	public Account addEducation(Long accountId, Education education) {
		Account account = findById(accountId);
		if (account != null) {
			account.addEducation(education);
			return save(account);
		}
		return null;
	}
	
	public Account addProject(Long accountId, Project work) {
		Account account = findById(accountId);
		if (account != null) {
			account.addProject(work);
			return save(account);
		}
		return null;
	}
}
