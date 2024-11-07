package com.ty.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.entity.Staff;
import com.ty.repository.StaffRepository;

@Service
public class StaffService {

	@Autowired
	private StaffRepository staffRepository;
	
	public boolean findByEmail(Staff staff) {
		Optional<Staff> res = staffRepository.findByEmail(staff.getEmail());
		if (res.isPresent()) {
			return false;
		} else {
			staffRepository.save(staff);
			return true;
		}
	}
	
	public boolean check(String email , String password) {
		Optional<Staff> res = staffRepository.findByEmail(email);
		if (res.isPresent()) {
			if (res.get().getPassword().equals(password)) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}
}
