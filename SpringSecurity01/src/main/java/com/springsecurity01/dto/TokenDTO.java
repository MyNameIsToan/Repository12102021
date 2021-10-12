package com.springsecurity01.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TokenDTO {
	private String Token;
	private Date ExpDate;
}
