package com.springsecurity01.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ListToOutput {
	private int page;
	private int totalPage;
	private List<NoteDTO> listResult = new ArrayList<>();
}
