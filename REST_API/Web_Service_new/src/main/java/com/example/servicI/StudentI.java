package com.example.servicI;

import java.util.List;
import java.util.Optional;

import com.example.model.Student;

public interface StudentI {
	
	public void save(Student stu);
	
	public List<Student> getAll();
	
	public Optional<Student> some(int sid);
	
	public void delete(int sid);

	public void update(int sid, Student stu) ;

}
