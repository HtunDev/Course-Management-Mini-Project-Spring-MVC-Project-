package com.HAH.mapping.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.HAH.mapping.model.service.CourseService;

@Controller
@EnableWebMvc
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public void index(Map<String, Object> model) {
		model.put("lists", courseService.getAll());
	}
	
	@GetMapping("/edit")
	public String editCourse() {
		return "course-edit";
	}
	
	@PostMapping
	public String saveCourse() {
		return "course-details";
	}


//	This is modelAndView Return 
//	@GetMapping
//	public ModelAndView index() {
//		var mv = new ModelAndView();
//		mv.getModel().put("lists", courseService.getAll());
//		mv.setViewName("course-list");
//		return mv;
//	}

	
//	This is return view only
//	@GetMapping
//	public String index(Map<String, Object> model) {
//		model.put("lists", courseService.getAll());
//		return "course-list";
//	}
}
