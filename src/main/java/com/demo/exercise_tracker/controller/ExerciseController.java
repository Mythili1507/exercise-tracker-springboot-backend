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

import com.demo.exercise_tracker.pojo.ExerciseEntry;
import com.demo.exercise_tracker.service.ExerciseService;


@RequestMapping("/exercise")
@RestController
public class ExerciseController 
{
	@Autowired
	private ExerciseService exerciseService;
	
	@PostMapping("/create")
	public ResponseEntity<String> create(ExerciseEntry exeEntry)
	{
		String body = null;
		HttpStatus status = null;
		
		try
		{
			boolean isCreateSuccessful = exerciseService.create(exeEntry);
			body = (isCreateSuccessful) ? "Success" : "Failure";
			status = (isCreateSuccessful) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			body = "failure";
			status = HttpStatus.BAD_REQUEST;
		}
		
		return new ResponseEntity<>(body, status);
	}
	
	@GetMapping("/get")
	public ResponseEntity<ExerciseEntry> get(@RequestParam int id)
	{
		ExerciseEntry exeEntry = exerciseService.get(id);
		
		return new ResponseEntity<>(exeEntry, HttpStatus.OK);
	}
	@GetMapping("/getAll")
	public Collection<ExerciseEntry> getAll()
	{
		return exerciseService.getAll();
	}
	@PatchMapping("/update")
	public ResponseEntity<String> update(@RequestBody ExerciseEntry exeEntry)
	{	
		ResponseEntity<String> response = null;
		String body = null;
		HttpStatus status = null;
		
		try
		{
			boolean isUpdateSuccessful = exerciseService.update(exeEntry);
			body = (isUpdateSuccessful) ? "Sucess" : "Failure";
			status = (isUpdateSuccessful) ? HttpStatus.OK : HttpStatus.NOT_FOUND;	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			body = "Failure";
			status = HttpStatus.NOT_FOUND;
		}
		
		response = new ResponseEntity<>(body, status);
		return response;
	}
	@DeleteMapping("/delete")
	public ResponseEntity<ExerciseEntry> delete(int id)
	{
		ResponseEntity<ExerciseEntry> response = null;
		ExerciseEntry body = null;
		HttpStatus status = null;
		
		try 
		{
			body = exerciseService.delete(id);
			status = (body!=null)? HttpStatus.OK : HttpStatus.NOT_FOUND;
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
