package com.HAH.mapping.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HAH.mapping.model.dto.Course;

@Service
public class CourseService {

	public int create(Course c) {
		return 0;
	}

	public Course findById(int id) {
		return null;
	}

	public List<Course> getAll() {
		return null;
	}

//	This is manual
//	private List<Course> coursesRepo;
//
//	@Autowired
//	private CourseCodeGenerator codeGenerator;
//
//	public CourseService() {
//		coursesRepo = new ArrayList<>();
//	}
//
//	@PostConstruct
//	public void init() {
//		create(new Course("Java Basic", 4, Level.Basic, 200000));
//		create(new Course("Spring", 3, Level.Advance, 180000));
//		create(new Course("Angular", 4, Level.Intermediate, 150000));
//		create(new Course("React", 4, Level.Intermediate, 200000));
//		create(new Course("Flutter", 4, Level.Basic, 180000));
//	}

//	public int create(Course c) {
//		var id = codeGenerator.next();
//		c.setId(id);
//		coursesRepo.add(c);
//		return id;
//	}
//
//	public Course findById(int id) {
//		return coursesRepo.stream().filter(c -> c.getId() == id).findAny().orElse(null);
//	}
//
//	public List<Course> getAll() {
//		return List.copyOf(coursesRepo);
//	}
}
