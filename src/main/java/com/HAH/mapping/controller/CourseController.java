package com.HAH.mapping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@RequestMapping("/course")
public class CourseController {

	@GetMapping
	public ModelAndView index() {
		var mv = new ModelAndView();
		mv.setViewName("course-list");
		return mv;
	}

}
