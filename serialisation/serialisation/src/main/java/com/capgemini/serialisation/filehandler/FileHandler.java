package com.capgemini.serialisation.filehandler;

import java.io.File;
import java.io.IOException;
import java.rmi.StubNotFoundException;

import com.capgemini.serialisation.entity.Student;
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

	public static void serialization() throws StreamWriteException, DatabindException, IOException {
		Student student = new Student(1,"Raja","raja@gmail.com",9530068726L);
		OBJECT_MAPPER.writeValue(FILE, student);
		System.out.println("Serialisation Done successfully...");
	}

	public static void deserialization() throws StreamReadException, DatabindException, IOException {
		Student student = OBJECT_MAPPER.readValue(FILE, Student.class);
		System.out.println("\n");
		System.out.println(student);
		System.out.println("\n");
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
