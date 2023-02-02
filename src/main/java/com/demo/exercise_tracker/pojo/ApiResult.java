package com.demo.exercise_tracker.pojo;

import java.time.LocalDateTime;

public class ApiResult
{
	public String result;
	public LocalDateTime operationTime;
	
	public ApiResult(String result, LocalDateTime operationTime)
	{
		this.result = result;
		this.operationTime = operationTime;
	}
	
	@Override
	public String toString()
	{
		return 	"{"+
					"\"result\" : \""+result +"\"" +
					"\"operationTime\" : \""+operationTime +"\""+ 
				"}";
	}
}
