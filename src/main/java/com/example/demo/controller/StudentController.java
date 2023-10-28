package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentRepository;
import com.example.demo.model.Student;

@RestController
@RequestMapping("students")
public class StudentController {
	
	@Autowired
	StudentRepository repository;

	//to get a single object
	@GetMapping
	public Student getName() {
		return new Student(1,"Test","Java");
	}
	
	//to get a list of objects
	@GetMapping("/list")
	public List<Student> getListNames(){
		List<Student> list = new ArrayList<>();
		list.add(new Student(1,"Rahul","Kumar"));
		list.add(new Student(2,"Amit","Singh"));
		list.add(new Student(3,"Chandan","Mishra"));
		list.add(new Student(4,"Raj","Tripathi"));
		list.add(new Student(5,"Sudesh","Lehri"));
		return list;
	}
	
	@PostMapping("/saveStudents")
	public String saveStudents(@RequestBody Student student) {
		repository.save(student);
		return "Data has been saved to db#####";
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getStudents(){
		return repository.findAll();
	}
	
	@GetMapping("/getAllStudents/{id}")
	public Optional<Student> getStudentsbyId(@PathVariable Integer id){
		return repository.findById(id);
	}
	
	//query param api
	@GetMapping("/getStudentsByQuery")
	public Optional<Student> getStudentByQueryParam(@RequestParam(name = "id") Integer id) {
		System.out.println("Printing id##################### : "+id);
		return repository.findById(id);
	}
	
	//query param api
		@GetMapping("/getStudentsQuery/{id}")
		public Optional<Student> getStudentQueryParam(@PathVariable Integer id) {
			return repository.findById(id);
		}
}
