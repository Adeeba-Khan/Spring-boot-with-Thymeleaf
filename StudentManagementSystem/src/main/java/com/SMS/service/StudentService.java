package com.SMS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SMS.entity.Student;
public interface StudentService {
	
	 List<Student> getAllStudents();

	 
	public Student saveStudent(Student student);


	void deleteDataById(long id);
	
	
	public Student getStudentById(long id);


	Student updateStudent(Student updatedStudent);
}
