package com.wwex.springbootsample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.wwex.springbootsample.model.Student;
import com.wwex.springbootsample.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value ="/students")
	public List<Student> getAllStudents(){
		return studentService.getAllStudent();
	}

}
