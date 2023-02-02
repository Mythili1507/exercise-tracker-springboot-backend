package com.demo.exercise_tracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.exercise_tracker.pojo.User;


@Repository
public interface UserDao extends JpaRepository<User, Integer>
{
	
}
