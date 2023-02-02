package com.demo.exercise_tracker.exceptions;

public class CrudException extends Exception
{
	private static final long serialVersionUID = -8032214416536518127L;
	
	public CrudException(String msg)
	{
		super(msg);
	}
}
