package com.example.Online.Examination.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Online.Examination.System.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmailId(String emailId);

}
