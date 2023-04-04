package com.SMS.controller;
import com.SMS.entity.Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SMS.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;
	
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}


	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
@GetMapping("/students/new")
public String createList(Model model) {
	Student student = new Student();
	
	model.addAttribute("student", student);
	return "Create_students";
	
}
@PostMapping("/students")
public String saveData(@ModelAttribute("students") Student student, Model model) {
studentService.saveStudent(student);	
//	model.addAttribute("student",studentService.getAllStudents());
	return "redirect:/students";
}

@GetMapping("/students/{id}")
public String deleteData(@PathVariable("id") long id){
	studentService.deleteDataById(id);
	return "redirect:/students";
}

@GetMapping("/students/edit/{id}")
public String editData(@PathVariable("id") long id, Model model){
	
	model.addAttribute("student",studentService.getStudentById(id));
	return "edit_Student";
	}

@PostMapping("/students/{id}")
public String updateStudent(@PathVariable("id") long id, @ModelAttribute("students") Student student) {

	// get student from database by id
			Student updatedStudent = studentService.getStudentById(id);
			updatedStudent.setId(id);
			updatedStudent.setFirstname(student.getFirstname());
			updatedStudent.setLastname(student.getLastname());
			updatedStudent.setEmail(student.getEmail());
			
			// save updated student object
			studentService.updateStudent(updatedStudent);
			return "redirect:/students";		
}


}
