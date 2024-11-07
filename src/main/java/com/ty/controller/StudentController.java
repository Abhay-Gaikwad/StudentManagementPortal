package com.ty.controller;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ty.dto.EmailDto;
import com.ty.entity.Staff;
import com.ty.entity.Student;
import com.ty.service.EmailService;
import com.ty.service.StaffService;
import com.ty.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private EmailService emailService;
	
	
	@GetMapping("/")
	public ModelAndView welcome() {
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("staff", new Staff());
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	@GetMapping("/register")
	public ModelAndView getMethodName() {
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}
	
	@PostMapping("/register")
	public ModelAndView registerPage(Staff staff ) {
		boolean res = staffService.findByEmail(staff);
		ModelAndView mv = new ModelAndView();
		if (res) {
			mv.setViewName("login");
			mv.addObject("msg", "Registration Successfull");
			return mv;
		}else {
			mv.setViewName("register");
			mv.addObject("msg", "Email Already Exist");
			return mv;
		}
	}
	
	@PostMapping("/login")
	public ModelAndView loginPage(HttpServletRequest request) {

		String email = request.getParameter("email");

		String password = request.getParameter("password");

		boolean result = staffService.check(email, password);
		ModelAndView mv = new ModelAndView();
		if (result) {
			List<Student> all = studentService.fetchAll();
			mv.setViewName("home");
			mv.addObject("students", all);
			mv.addObject("msg", "Welcome to App");
		} else {
			mv.setViewName("login");
			mv.addObject("msg", "Invalid credentials");
		}

		return mv;
	}
	
	@GetMapping("/home")
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView("home");
		List<Student> all = studentService.fetchAll();
		mv.addObject("students", all);
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView studentPage() {
		ModelAndView mv = new ModelAndView("student");
		mv.addObject("student",new Student());
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView saveStudent(Student student) {
		Student save = studentService.save(student);
		ModelAndView mv = new ModelAndView("home");
		List<Student> all = studentService.fetchAll();
		mv.addObject("students", all);
		if (save!=null) {
			mv.addObject("msg", "Student info is added");
		} else {
			mv.addObject("msg", "Student info is not added. Something went wrong");
		}	
		return mv;
	}
	
	@GetMapping("/update")
	public ModelAndView update(@RequestParam Integer sid) {
		Student student = studentService.findById(sid);
		ModelAndView mv = new ModelAndView("update");
		mv.addObject("student", student);
		return mv;
	}
	
	@PostMapping("/update")
	public ModelAndView updatePage( Student student) {
		studentService.save(student);
		ModelAndView mv = new ModelAndView("home");
		List<Student> all = studentService.fetchAll();
		mv.addObject("students", all);
		mv.addObject("msg", "Student Info is Updated");
		return mv;
	}
	
	@GetMapping("/delete")
	public ModelAndView deletStudent(@RequestParam Integer sid) {
		studentService.deleteById(sid);
		ModelAndView mv = new ModelAndView("home");
		List<Student> all = studentService.fetchAll();
		mv.addObject("students", all);
		mv.addObject("msg", "Deleted");
		return mv;
	}
	
	@GetMapping("/email")
	public ModelAndView displayEmail() {
		ModelAndView mv = new ModelAndView("email");
		mv.addObject("emaildto", new EmailDto());
		return mv;
	}
	
	@PostMapping("/send")
	public ModelAndView sendEmail(EmailDto dto) {
		emailService.send(dto);
		ModelAndView mv = new ModelAndView("home");
		List<Student> all = studentService.fetchAll();
		mv.addObject("students", all);
		mv.addObject("msg", "Mail sent");
		return mv;
	}
	
}
