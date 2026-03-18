package com.capgemini.serialisation.one_to_many.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student implements Serializable{
	
	
	private Integer id;
	private String name;
	private String mailId;
	private Long contactNumber;
	Project[] projects;
}
