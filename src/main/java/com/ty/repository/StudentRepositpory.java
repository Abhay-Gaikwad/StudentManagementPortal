package com.ty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.entity.Student;

public interface StudentRepositpory extends JpaRepository<Student, Integer>{

}
