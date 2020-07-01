package com.laptrinhjavaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.api.output.UserOutput;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;

@CrossOrigin
@RestController
public class UserAPI {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping(value = "/user")
	public UserOutput showNew(@RequestParam("page") int page,
							 @RequestParam("limit") int limit) {
		UserOutput result = new UserOutput();
		result.setPage(page);
		Pageable pageable = new PageRequest(page - 1, limit);
		result.setListResult(userService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (userService.totalItem()) / limit));
		return result;
	}

	@PostMapping(value = "/user")
	public UserDTO createNew(@RequestBody UserDTO model) {
		return userService.save(model);
	}
	
	@PutMapping(value = "/user/{id}")
	public UserDTO updateNew(@RequestBody UserDTO model, @PathVariable("id") long id) {
		model.setUserID(id);
		return userService.save(model);
	}
	
	@DeleteMapping(value = "/user")
	public void deleteNew(@RequestBody long[] ids) {
		userService.delete(ids);
	}
}
