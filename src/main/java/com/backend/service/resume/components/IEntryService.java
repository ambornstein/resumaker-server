package com.backend.service.resume.components;

public interface IEntryService<T> {
	T assignToResume(Long resumeId, Long entryId);
	
	T removeFromResume(Long resumeId, Long entryId);
	
	T save(T obj);
}
