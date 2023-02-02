package com.demo.exercise_tracker.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exercise_tracker.dao.ExerciseDao;
import com.demo.exercise_tracker.pojo.ExerciseEntry;

@Service
public class ExerciseService 
{
	@Autowired
	ExerciseDao exerciseDao;
	
	public boolean create(ExerciseEntry exercise)
	{
		ExerciseEntry savedExercise = exerciseDao.save(exercise);
		return (savedExercise!=null)? true: false;
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
		if(exerciseDao.existsById(exerciseEntry.id))
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
