package com.wwex.springbootsample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.wwex.springbootsample.dao.StudentDao;
import com.wwex.springbootsample.model.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	public List<Student> getAllStudent(){
		return studentDao.getAllStudents();
	}

}
