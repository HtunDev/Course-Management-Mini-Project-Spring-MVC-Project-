package com.HAH.mapping.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HAH.mapping.model.dto.Course;

@Service
public class CourseService {

	private List<Course> coursesRepo;

	@Autowired
	private CourseCodeGenerator codeGenerator;

	public CourseService() {
		coursesRepo = new ArrayList<>();
	}

	public int create(Course c) {
		var id = codeGenerator.next();
		c.setId(id);
		coursesRepo.add(c);
		return id;
	}

	public Course findById(int id) {
		return coursesRepo.stream().filter(c -> c.getId() == id).findAny().orElse(null);
	}

	public List<Course> getAll() {
		return List.copyOf(coursesRepo);
	}
}
