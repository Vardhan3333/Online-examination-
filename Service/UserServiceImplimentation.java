package com.example.Online.Examination.System.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Online.Examination.System.Model.User;
import com.example.Online.Examination.System.Repository.UserRepository;

@Service
public class UserServiceImplimentation {
	
	@Autowired
	UserRepository urepo;
	
	public Boolean save(User user) {
		user.setRole("User");
		urepo.save(user);
		return true;
	}
	
	public Boolean saveAdmin(User user) {
		System.out.println("admin");
		user.setRole("Admin");
		user.setStatus("Pending");
		urepo.save(user);
		return true;
	}
	
	public User findUser(String email) {
		User user =urepo.findByEmailId(email);
		return user;
	}
	
	public Boolean check(User user,String password) {
		if(user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	

}
