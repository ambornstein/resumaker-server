package com.backend.service.account;

import java.util.List;
import java.util.Set;

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

	public Set<Resume> findAllResumesById(Long id) {
		return accountRepository.findById(id).get().getResumes();
	}
	
	public void deleteById(Long id) {
		accountRepository.deleteById(id);
	}

	public Account updateById(Long id, Account account) {
		Account existingAccount = findById(id);
		if (existingAccount != null) {
			existingAccount.setFirstName(account.getFirstName());
			existingAccount.setLastName(account.getLastName());
			existingAccount.setEmail(account.getEmail());
			existingAccount.setPhoneNumber(account.getPhoneNumber());
			existingAccount.setLocation(account.getLocation());
			existingAccount.setLinkedInLink(account.getLinkedInLink());
			existingAccount.setGithubLink(account.getGithubLink());
			existingAccount.setUSCitizen(account.getUSCitizen());
			existingAccount.setWebsite(account.getWebsite());

			return save(existingAccount);
		}
		return null;
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
	
	public Set<Resume> getResumesById(Long accountId) {
		Account account = findById(accountId);
		if (account != null) {
			return (Set<Resume>) account.getResumes();
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
	
	public Account removeWorkExperince(Long accountId, Long workId) {
		Account account = findById(accountId);
		if (account != null) {
			WorkExperience work = account.getWorkExperiences().stream().filter(r -> r.getId().equals(workId)).findFirst()
					.orElse(null);
			if (work != null) {
				account.removeWorkExperience(work);
				return save(account);
			}
		}
		return null;
	}
	
	public Set<WorkExperience> getWorkExperiencesById(Long accountId) {
		Account account = findById(accountId);
		if (account != null) {
			return account.getWorkExperiences();
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
	
	public Account removeEducation(Long accountId, Long educationId) {
		Account account = findById(accountId);
		if (account != null) {
			Education education = account.getEducationEntries().stream().filter(r -> r.getId().equals(educationId)).findFirst()
					.orElse(null);
			if (education != null) {
				account.removeEducation(education);
				return save(account);
			}
		}
		return null;
	}
	
	public Set<Education> getEducationById(Long accountId) {
		Account account = findById(accountId);
		if (account != null) {
			return account.getEducationEntries();
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
	
	public Account removeProject(Long accountId, Long projectId) {
		Account account = findById(accountId);
		if (account != null) {
			Project project = account.getProjects().stream().filter(r -> r.getId().equals(projectId)).findFirst()
					.orElse(null);
			if (project != null) {
				account.removeProject(project);
				return save(account);
			}
		}
		return null;
	}
	
	public Set<Project> getProjectsById(Long accountId) {
		Account account = findById(accountId);
		if (account != null) {
			return account.getProjects();
		}
		return null;
	}
}
