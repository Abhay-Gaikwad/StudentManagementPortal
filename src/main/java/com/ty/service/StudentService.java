package com.ty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ty.entity.Student;
import com.ty.repository.StaffRepository;
import com.ty.repository.StudentRepositpory;

@Service
public class StudentService {

	@Autowired
	private StudentRepositpory studentRepositpory;
	
	public List<Student> fetchAll() {
		List<Student> ls = studentRepositpory.findAll();
		return ls;
	}

	public Student save(Student student) {
		return studentRepositpory.save(student);
	}
	
	public Student findById(Integer sid) {
		Student student = studentRepositpory.findById(sid).get();
		return student;
	}

	public void deleteById(Integer sid) {
		studentRepositpory.deleteById(sid);
	}
	
}
