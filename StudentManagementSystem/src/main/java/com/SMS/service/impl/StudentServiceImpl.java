package com.SMS.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.SMS.entity.Student;
import com.SMS.repository.StudentRepository;
import com.SMS.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}


	@Override
	public void deleteDataById(long id) {
		studentRepository.deleteById(id);
		
		
	}


	@Override
	public Student getStudentById(long id) {
		Optional<Student> studentById =  studentRepository.findById(id);
		
		Student student = studentById.get();
		return student;
	}


	@Override
	public Student updateStudent(Student updatedStudent) {
		return studentRepository.save(updatedStudent);
		
	}
	}


	

	


