package com.capgemini.serialisation.many_to_one.execution;

import java.io.IOException;

import com.capgemini.serialisation.one_to_one.entity.Project;
import com.capgemini.serialisation.one_to_one.entity.Student;
import com.capgemini.serialisation.one_to_one.filehandler.FileHandler;

public class JavaApp {
	public static void execution() {
		
		Project project = new Project (1,"Airline Reservation","Java based App");
		Student student = new Student (1,"Raja","raja@gmail.com",9530068726L,project);

		
		
		
		
		
		try {
			FileHandler.createTheFile();
			FileHandler.serialization(student);
			FileHandler.deserialization();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
