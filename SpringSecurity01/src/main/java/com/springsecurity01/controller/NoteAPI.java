package com.springsecurity01.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity01.config.JwtUtil;
import com.springsecurity01.config.UserPrincipal;
import com.springsecurity01.dto.ListToOutput;
import com.springsecurity01.dto.NoteDTO;
import com.springsecurity01.entity.Token;
import com.springsecurity01.service.INoteService;
import com.springsecurity01.service.TokenService;

@RestController
public class NoteAPI {
	@Autowired
	private INoteService noteService;

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping(value = "/Note")
	@PreAuthorize("hasAnyAuthority('USER_READ')")
	public List<NoteDTO> GetAll() {
		return noteService.GetAll();
	}
	
	@GetMapping(value = "/GetPaging")
	@PreAuthorize("hasAnyAuthority('USER_READ')")
	public ListToOutput showNote(@RequestParam("page") int page,
							 @RequestParam("limit") int limit) {
		final String authorizationHeader = request.getHeader("Authorization");
		UserPrincipal user = null;
		Token token = null;
		if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Token ")) {
			String jwt = authorizationHeader.substring(6);
			user = jwtUtil.getUserFromToken(jwt);
			token = tokenService.findByToken(jwt);
		}
		if (null != user && null != token && token.getTokenExpDate().after(new Date())) {
			ListToOutput result = new ListToOutput();
			result.setPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setListResult(noteService.findAll(user.getUsername(),pageable));
			result.setTotalPage((int) Math.ceil((double) (noteService.totalItem(user.getUsername())) / limit));
			return result;
		}else {
			return null;
		}
	}
	
	@GetMapping(value = "/GetFinish")
	@PreAuthorize("hasAnyAuthority('USER_READ')")
	public ListToOutput showFinish(@RequestParam("page") int page,
							 @RequestParam("limit") int limit) {
		final String authorizationHeader = request.getHeader("Authorization");
		UserPrincipal user = null;
		Token token = null;
		if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Token ")) {
			String jwt = authorizationHeader.substring(6);
			user = jwtUtil.getUserFromToken(jwt);
			token = tokenService.findByToken(jwt);
		}
		if (null != user && null != token && token.getTokenExpDate().after(new Date())) {
			ListToOutput result = new ListToOutput();
			result.setPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setListResult(noteService.FindAllIsFinish(user.getUsername(),pageable));
			result.setTotalPage((int) Math.ceil((double) (noteService.totalFinish(user.getUsername())) / limit));
			return result;
		}else {
			return null;
		}
	}
	
	
	@GetMapping(value = "/Search/{keyword}")
	@PreAuthorize("hasAnyAuthority('USER_READ')")
	public List<NoteDTO> GetSearch(@PathVariable("keyword") String keyword) {
		final String authorizationHeader = request.getHeader("Authorization");
		UserPrincipal user = null;
		Token token = null;
		if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Token ")) {
			String jwt = authorizationHeader.substring(6);
			user = jwtUtil.getUserFromToken(jwt);
			token = tokenService.findByToken(jwt);
		}
		if (null != user && null != token && token.getTokenExpDate().after(new Date())) {
			return noteService.Search(user.getUsername(), keyword);
		}else {
			return null;
		}
	}
	
	
	@PostMapping(value = "/Note")
	@PreAuthorize("hasAnyAuthority('USER_CREATE')")
	public void Save(@RequestBody NoteDTO model) {
		final String authorizationHeader = request.getHeader("Authorization");
		UserPrincipal user = null;
		Token token = null;
		if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Token ")) {
			String jwt = authorizationHeader.substring(6);
			user = jwtUtil.getUserFromToken(jwt);
			token = tokenService.findByToken(jwt);
		}
		if (null != user && null != token && token.getTokenExpDate().after(new Date())) {
			model.setUsername(user.getUsername());
			noteService.Save(model);
		}
	}
	
	@GetMapping(value = "/Note/{id}")
	@PreAuthorize("hasAnyAuthority('USER_UPDATE')")
	public void UpdateIsFinish(@PathVariable("id") Long id) {
		final String authorizationHeader = request.getHeader("Authorization");
		UserPrincipal user = null;
		Token token = null;
		if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Token ")) {
			String jwt = authorizationHeader.substring(6);
			user = jwtUtil.getUserFromToken(jwt);
			token = tokenService.findByToken(jwt);
		}
		if (null != user && null != token && token.getTokenExpDate().after(new Date())) {
			noteService.UpdateIsFinish(id);
		}
	}

	@PutMapping(value = "/Note")
	@PreAuthorize("hasAnyAuthority('USER_UPDATE')")
	public void Update(@RequestBody NoteDTO model) {
		final String authorizationHeader = request.getHeader("Authorization");
		UserPrincipal user = null;
		Token token = null;
		if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Token ")) {
			String jwt = authorizationHeader.substring(6);
			user = jwtUtil.getUserFromToken(jwt);
			token = tokenService.findByToken(jwt);
		}
		if (null != user && null != token && token.getTokenExpDate().after(new Date())) {
			model.setUsername(user.getUsername());
			noteService.Update(model);
		}
	}

	@DeleteMapping(value = "/Note/{id}")
	@PreAuthorize("hasAnyAuthority('USER_DELETE')")
	public void Delete(@PathVariable("id") Long id) {
		noteService.Delete(id);
	}
}
