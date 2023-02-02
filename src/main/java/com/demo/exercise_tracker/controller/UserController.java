package com.demo.exercise_tracker.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exercise_tracker.pojo.User;
import com.demo.exercise_tracker.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody User user)
	{
		ResponseEntity<String> response = null;
		String body = null;
		HttpStatus status = null;
		
		try
		{
			boolean isCreateSuccessful = userService.create(user);
			body = (isCreateSuccessful)? "Success" : "Failure";
			status = (isCreateSuccessful)? HttpStatus.OK : HttpStatus.BAD_REQUEST;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			body = "Failure";
			status = HttpStatus.BAD_REQUEST;
		}
		
		response = new ResponseEntity<>(body, status);
		return response;
	}
	
	@GetMapping("/get")
	public ResponseEntity<User> get(@RequestParam int id)
	{
		User body = userService.get(id);
		HttpStatus status = (body!=null) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(body, status);
	}
	
	@GetMapping("/getAll")
	public Collection<User> getAll()
	{
		return userService.getAll();
	}
	
	@PatchMapping("/update")
	public ResponseEntity<String> update(@RequestBody User user)
	{
		ResponseEntity<String> response = null;
		String body = null;
		HttpStatus status = null;
		
		try
		{
			boolean isUpdateSuccess = userService.update(user);
			body = (isUpdateSuccess) ? "Success" : "Failure";
			status = (isUpdateSuccess) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			body = "Failure";
			status = HttpStatus.BAD_REQUEST;
		}
		
		response = new ResponseEntity<>(body, status);
		return response;
	}
	
	@DeleteMapping
	public ResponseEntity<User> delete(@RequestParam int id)
	{
		ResponseEntity<User> response = null;
		User body = null;
		HttpStatus status = null;
		
		try
		{
			body = userService.delete(id);
			status = (body!=null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			body = null;
			status = HttpStatus.BAD_REQUEST;
		}
		
		response = new ResponseEntity<>(body, status);
		return response;
	}
}

