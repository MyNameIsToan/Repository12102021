package com.springsecurity01.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.springsecurity01.dto.NoteDTO;

public interface INoteService {
	List<NoteDTO> FindAllIsFinish(String username,Pageable pageable);
	List<NoteDTO> findAll(String username, Pageable pageable);
	List<NoteDTO> GetAll();
	void Save(NoteDTO note);
	void Update(NoteDTO note);
	void Delete(Long id);
	int totalItem(String username);
	int totalFinish(String username);
	List<NoteDTO> Search(String username, String Content);
	void UpdateIsFinish(Long id);
}
