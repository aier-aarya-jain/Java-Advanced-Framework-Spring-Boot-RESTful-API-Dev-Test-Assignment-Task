package com.capgemini.serialisation.many_to_many.entity;

import java.io.Serializable;
import java.util.List;

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
	private List<Project> projects;
}
