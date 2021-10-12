package com.springsecurity01.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "t_user")
@Data
public class User extends BaseEntity {
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
	@OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<NoteEntity> ListOfNote;
	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "t_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<>();	
}
