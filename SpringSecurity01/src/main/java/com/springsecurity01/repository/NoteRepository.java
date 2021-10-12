package com.springsecurity01.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springsecurity01.entity.NoteEntity;
import com.springsecurity01.entity.User;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
	
	@Query(value="Select * FROM notelist WHERE users = ?1 AND content LIKE %?2%",nativeQuery = true)
	List<NoteEntity> SearchNote(User user,String Content);
	
	List<NoteEntity> findByUsersAndIsfinish(User user,int isfinish,Pageable pageable);
	
	List<NoteEntity> findByUsersAndIsfinish(User user,int isfinish);
	
	List<NoteEntity> findByUsers(User user, Pageable Pageable);
	
	List<NoteEntity> findByUsers(User user);
	
	List<NoteEntity> findAllByparentId(Long ParentID);
}
  