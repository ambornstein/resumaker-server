package com.backend.service.resume;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

	@Autowired
	private ResumeRepository resumeRepository;
	
	public Resume save(Resume resume) {
		return resumeRepository.save(resume);
	}
	
	public List<Resume> findAll() {
		return resumeRepository.findAll();
	}
	
	public Resume findById(Long id) {
		return resumeRepository.findById(id).orElse(null);
	}
	
	public void deleteById(Long id) {
		resumeRepository.deleteById(id);
	}
}
