package com.springsecurity01.dto;

import lombok.Data;

@Data
public class NoteDTO {
	private Long id;
	private Long parentid;
	private String content;
	private String username;
	private int haschild;
	private int isfinish;
}
