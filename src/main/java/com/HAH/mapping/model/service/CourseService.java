package com.HAH.mapping.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.HAH.mapping.model.dto.Course;
import com.HAH.mapping.model.dto.Level;

@Service
public class CourseService {

    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    private RowMapper<Course> rowMapper;

//    public CourseService() {
//        rowMapper = (rs, index) -> {
//            var c = new Course();
//            c.setId(rs.getInt("id"));
//            c.setName(rs.getString("name"));
//            c.setLevel(Level.valueOf(rs.getString("level")));
//            c.setDuration(rs.getInt("duration"));
//            c.setFees(rs.getInt("fees"));
//            // If description column is added, set it here
//            c.setDescription(rs.getString("description"));
//            return c;
//        };
//    }
    
    public CourseService() {
        rowMapper = new BeanPropertyRowMapper<>(Course.class);
    }

    public int save(Course c) {
    	
    	if(c.getId() > 0) {
    		simpleJdbcInsert.getJdbcTemplate().update("update course set name = ?, level = ?, duration = ?, fees = ?, description = ? where id = ? ", 
    				c.getName(), c.getLevel().name(), c.getDuration(),
    				c.getFees(), c.getDescription(), c.getId());
    		
    		return c.getId();
    	}
    
        var params = new HashMap<String, Object>();
        params.put("name", c.getName());
        params.put("level", c.getLevel().name());
        params.put("duration", c.getDuration());
        params.put("fees", c.getFees());
        // If description column is added, include it in params
        params.put("description", c.getDescription());

        return simpleJdbcInsert.executeAndReturnKeyHolder(params).getKey().intValue();
    }

    public Course findById(int id) {
        return simpleJdbcInsert.getJdbcTemplate().query("select * from course where id = ?", rowMapper, id).stream()
                .findAny().orElse(null);
    }

    public List<Course> getAll() {
        return simpleJdbcInsert.getJdbcTemplate().query("select * from course", rowMapper);
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
