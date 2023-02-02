package com.demo.exercise_tracker.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exercise_tracker.dao.UserDao;
import com.demo.exercise_tracker.pojo.User;


@Service
public class UserService
{
	@Autowired
	private UserDao userDao;
	
	public boolean create(User user)
	{
		User savedUser = userDao.save(user);
		return (savedUser!=null) ? true : false;
	}
	
	public User get(int id)
	{
		return	userDao.findById(id).orElse(null);
	}
	public Collection<User> getAll()
	{
		return userDao.findAll();
	}
	
	public boolean update(User user)
	{
		if(userDao.existsById(user.id))
		{
			userDao.save(user);
			return true;
		}
		else return false;
	}
	public User delete(int id)
	{
		User userToDelete = userDao.findById(id).orElse(null);
		if(userToDelete!=null)
		{
			userDao.deleteById(id);
			return userToDelete;
		}
		else return null;
	}
}
