package com.HAH.mapping.model.dto;

import lombok.Data;

@Data
public class Course {

	private int id;
	private String name;
	private int duration;
	private Level level;
	private int fees;

	public Course() {
	}

	public Course(String name, int duration, Level level, int fees) {
		super();
		this.name = name;
		this.duration = duration;
		this.level = level;
		this.fees = fees;
	}

	

}
