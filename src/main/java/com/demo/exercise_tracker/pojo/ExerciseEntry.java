package com.demo.exercise_tracker.pojo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ExerciseEntry
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String exerciseName;
	public int userId;
	public LocalDateTime startTime;
	public LocalDateTime endTime;
	public long durationMillis;
}
