package com.capgemini.serialisation.many_to_many.filehandler;

import java.io.File;
import com.capgemini.serialisation.many_to_many.entity.Project;
import com.capgemini.serialisation.many_to_many.entity.Student;

import java.io.IOException;
import java.rmi.StubNotFoundException;
import java.util.List;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class FileHandler {
	
	private static final String PATH= "src/main/resources/Student.json";
	private static final File FILE = new File(PATH);
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	
	
	
	public static void createTheFile() throws IOException {
		if(FILE.createNewFile()) {
			System.out.println("JSON file created successfully..");
		}
		else {
			System.out.println("JSON file already exists...");
		}
	}

	public static void serialization(List<Student> stu) throws StreamWriteException, DatabindException, IOException {
		OBJECT_MAPPER.writeValue(FILE, stu);
		System.out.println("Serialisation Done successfully...");
	}

	public static void deserialization() throws StreamReadException, DatabindException, IOException {
		Student [] student = OBJECT_MAPPER.readValue(FILE, Student[].class);
		for(Student stu : student) {
			System.out.println("\n");
			System.out.println("ID: "+ stu.getId());
			System.out.println("Name: "+ stu.getName());
			System.out.println("MailId: "+ stu.getMailId());
			System.out.println("Contact Number: "+ stu.getContactNumber());


			List<Project> projects = stu.getProjects();
			for(Project pro : projects) {
				System.out.println();
				System.out.println(pro);
			}
			
		}
		
		System.out.println("De-Serialisation Done successfully...");
	}

	public static  void deleteTheFile() {
		if(FILE.delete()) {
			System.out.println("JSON file deleted successfully..");
		}
		else {
			System.out.println("JSON file doesn't exists...");
		}
	}
}
