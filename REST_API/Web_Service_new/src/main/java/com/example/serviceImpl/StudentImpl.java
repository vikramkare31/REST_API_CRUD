package com.example.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.model.Student;
import com.example.repository.StudentDao;
import com.example.servicI.StudentI;

@Service
public class StudentImpl implements StudentI{

	@Autowired
	StudentDao sdi;
	
	@Override
	public void save(Student stu) {
		
		/*
		Student ss=new Student();
		ss.setSid(101);
		ss.setName("Vikram");
		ss.setAddress("MH");

		
		Student s1=new Student();
		s1.setSid(111);
		s1.setName("VK");
		s1.setAddress("AA");
		
		Student s2=new Student();
		s2.setSid(123);
		s2.setName("abc");
		s2.setAddress("aaaa");
		
		List<Student> stu=new ArrayList<>();
		stu.add(ss);
		stu.add(s1);
		stu.add(s2);

		sdi.saveAll(stu);
		*/
		
		sdi.save(stu);
	}

	@Override
	public List<Student> getAll() {

		List<Student> st=new ArrayList();
		sdi.findAll().forEach(st1->st.add(st1));
		return st;
	}

	@Override
	public Optional<Student> some(int sid) {
		
		return sdi.findById(sid);
	}

	@Override
	public void delete(int sid) {
		
		sdi.deleteById(sid);
	}

	@Override
	@Modifying
	@Transactional
	public void update(int sid, Student stu)   
	{  
		Student st=sdi.findById(sid).get();
		st.setName(stu.getName());
		st.setAddress(stu.getAddress());
	sdi.save(st);  
	}

	
	

	
}
