package com.demo.exercise_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExerciseTrackerApp 
{
    public static void main( String[] args )
    {
        System.out.println("ExerciseTrackerApp loading");
        SpringApplication.run(ExerciseTrackerApp.class, args);
        System.out.println("ExerciseTrackerApp running");
    }
}
