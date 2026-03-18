package com.capgemini.serialisation.execution;

import java.io.IOException;

import com.capgemini.serialisation.filehandler.FileHandler;

public class JavaApp {
	public static void execution() {
		System.out.println("Hello World!!");
		try {
			
			FileHandler.createTheFile();
			FileHandler.serialization();
			FileHandler.deserialization();
			FileHandler.deleteTheFile();
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
