package com.wwex.springbootsample.dao;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.wwex.springbootsample.model.Student;

@Repository
public class StudentDao {
	
	public List<Student>getAllStudents(){
		return allStudents();
	}
	
	private List<Student>allStudents(){
		List<Student> students = new ArrayList<>();
		
		Student gebremedhin = new Student("Gebremedhin", "Taddese", 34);
		Student befrdu = new Student("Befrdu", "Seifu", 30);
		Student yonas = new Student("Yonas", "Taddese", 32);
		
		students.add(gebremedhin);
		students.add(befrdu);
		students.add(yonas);
		
		return students;
	}
}
