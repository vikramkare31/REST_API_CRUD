package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.servicI.StudentI;

@RestController
public class Homecontroller {
	

	@Autowired
	StudentI sdi;

	
	@RequestMapping("/")
	public List<Student> preLogin()
	{

		
		sdi.save(null);

		List<Student> stu=new ArrayList<>();
		return stu;
	}
	
	@PostMapping("/save")
	public Student saveData(@RequestBody Student stu)
	{

		
		sdi.save(stu);
		return stu;
		
		

	}
	

	//http://localhost:8085/users/admin/admin--select All Users
	
	@GetMapping("/users/{admin}/{admin}")
	public List<Student> all(@PathVariable("admin")String username,@PathVariable("admin")String password)
	{
		List<Student> st=sdi.getAll();
		return st;	
}
	
	//http://localhost:8085/user/1--select single User based on id
	
	@GetMapping("/user/{sid}")
	public Optional<Student> sone(@PathVariable("sid") Integer sid,Student s)
	{
		Optional<Student> st=sdi.some(sid);
		return st;	
}
	
	
	//http://localhost:8085/delete/2--Delete 2 user
	
	@DeleteMapping("/delete/{sid}")
	public void delete(@PathVariable("sid") Integer sid)
	{
		sdi.delete(sid);
	}
	
	
	//http://localhost:8085/update/7--Update 7th user
	
	@PutMapping("/update/{sid}")  
	private Student update(@PathVariable("sid") Integer sid,@RequestBody Student stu)   
	{  
	sdi.update(sid,stu);  
	return stu;  
	} 
	
	
	
	
}