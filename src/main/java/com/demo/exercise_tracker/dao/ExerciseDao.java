package com.demo.exercise_tracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.exercise_tracker.pojo.ExerciseEntry;


@Repository
public interface ExerciseDao extends JpaRepository<ExerciseEntry, Integer>
{

}
