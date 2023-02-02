package com.demo.exercise_tracker.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exercise_tracker.dao.ExerciseDao;
import com.demo.exercise_tracker.dao.UserDao;
import com.demo.exercise_tracker.pojo.ExerciseEntry;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class ExerciseService 
{
	@Autowired
	private ExerciseDao exerciseDao;
	@Autowired
	private UserDao userDao;
	
	
	public boolean create(ExerciseEntry exercise) throws JsonProcessingException
	{
		if(userDao.existsById(exercise.userId))
		{
			ExerciseEntry savedExercise = exerciseDao.save(exercise);
			return (savedExercise!=null)? true: false;
		}
		else return false;
	}
	
	public ExerciseEntry get(int id)
	{
		return exerciseDao.findById(id).orElse(null);
	}
	
	public Collection<ExerciseEntry> getAll()
	{
		return exerciseDao.findAll();
	}
	
	public boolean update(ExerciseEntry exerciseEntry)
	{
		if(exerciseDao.existsById(exerciseEntry.id) && userDao.existsById(exerciseEntry.userId) )
		{
			exerciseDao.save(exerciseEntry);
			return true;
		}
		else return false;
	}
	
	public ExerciseEntry delete(int id)
	{
		ExerciseEntry exeEntry =  exerciseDao.findById(id).orElse(null);
		exerciseDao.deleteById(id);
		return exeEntry;
	}
}
