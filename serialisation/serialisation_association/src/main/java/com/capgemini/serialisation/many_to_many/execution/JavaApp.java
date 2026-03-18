package com.capgemini.serialisation.many_to_many.execution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.serialisation.many_to_many.entity.Project;
import com.capgemini.serialisation.many_to_many.entity.Student;
import com.capgemini.serialisation.many_to_many.filehandler.FileHandler;

public class JavaApp {
	public static void execution() {
		
		Project project1 = new Project (1,"Airline Reservation","Java based App");
		Project project2 = new Project (1,"Airline Reservation","Java based App");
		Project project3 = new Project (1,"Airline Reservation","Java based App");

		List<Project> projects = new ArrayList<Project>();
		projects.add(project1);
		projects.add(project2);
		projects.add(project3);
		
		Student student1 = new Student (1,"Raja","raja@gmail.com",9530068726L,projects);
		Student student2 = new Student (2,"Rani","rani@gmail.com",9530068726L,projects);
		Student student3 = new Student (3,"Ravi","ravi@gmail.com",9530068726L,projects);
		
		List<Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		students.add(student3);

		
		
		
		
		
		
		try {
			FileHandler.createTheFile();
			FileHandler.serialization(students);
			FileHandler.deserialization();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
