package com.rest.api.conrtoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rest.api.entity.Student;
import com.rest.api.services.StudentServices;

@Controller
public class StudentController {

	@Autowired
	private StudentServices studentServices;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String addShowForm() {
		return "redirect:/showStudent";
	}

	@RequestMapping(path = "/showStudent", method = RequestMethod.GET)
	public String showAllStudents(Model model) {
		List<Student> students = this.studentServices.getAllStudent();
		model.addAttribute("students", students);
		return "listOfStudent";
	}

	@RequestMapping(path = "/showAddStudent", method = RequestMethod.GET)
	public String showAddStudent() {
		return "addStudent";
	}
	
	@RequestMapping(path = "/showUpdateStudent/{id}", method = RequestMethod.GET)
	public String showUpdateStudent(@PathVariable("id") int id,Model model) {
		Student student = this.studentServices.getStudent(id);
		model.addAttribute("student", student);
		return "updateStudent";
	}
	
	@RequestMapping(path = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute Student student) {
		this.studentServices.createStudent(student);
		return "redirect:/";
	}
	

	@RequestMapping(path = "/updateStudent", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute Student student) {
		this.studentServices.updateStudent(student.getId(), student);
		return "redirect:/";
	}

	@RequestMapping(path = "/deleteStudent/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") int id) {
		this.studentServices.deleteStudent(id);
		return "redirect:/";
	}

}
