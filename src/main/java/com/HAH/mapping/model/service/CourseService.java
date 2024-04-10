package com.HAH.mapping.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.HAH.mapping.model.dto.Course;
import com.HAH.mapping.model.dto.Level;

@Service
public class CourseService {

	private final SimpleJdbcInsert simpleJdbcInsert;

	@Autowired
	public CourseService(SimpleJdbcInsert simpleJdbcInsert) {
		this.simpleJdbcInsert = simpleJdbcInsert;
	}

	public int create(Course c) {
		Map<String, Object> params = new HashMap<>();
		params.put("name", c.getName());
		params.put("level", c.getLevel().name());
		params.put("duration", c.getDuration());
		params.put("fees", c.getFees());
		params.put("description", c.getDescription());

		return simpleJdbcInsert.executeAndReturnKeyHolder(params).getKey().intValue();
	}

	public Course findById(int id) {
		return simpleJdbcInsert.getJdbcTemplate().queryForObject("SELECT * FROM course WHERE id = ?", (rs, rowNum) -> {
			Course course = new Course();
			course.setId(rs.getInt("id"));
			course.setName(rs.getString("name"));
			course.setLevel(Level.valueOf(rs.getString("level")));
			course.setDuration(rs.getInt("duration"));
			course.setFees(rs.getInt("fees"));
			course.setDescription(rs.getString("description"));
			return course;
		}, id);
	}

	public List<Course> getAll() {
		return simpleJdbcInsert.getJdbcTemplate().query("SELECT * FROM course", (rs, rowNum) -> {
			Course course = new Course();
			course.setId(rs.getInt("id"));
			course.setName(rs.getString("name"));
			course.setLevel(Level.valueOf(rs.getString("level")));
			course.setDuration(rs.getInt("duration"));
			course.setFees(rs.getInt("fees"));
			course.setDescription(rs.getString("description"));
			return course;
		});
	}
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
