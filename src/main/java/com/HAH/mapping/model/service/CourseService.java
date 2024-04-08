package com.HAH.mapping.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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

	@PostConstruct
	public void init() {
		create(new Course("Java Basic", 4, "Basic", 200000));
		create(new Course("Spring", 3, "Advance", 180000));
		create(new Course("Angular", 4, "Intermediate", 150000));
		create(new Course("React", 4, "Intermediate", 200000));
		create(new Course("Flutter", 4, "Basic", 180000));
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
