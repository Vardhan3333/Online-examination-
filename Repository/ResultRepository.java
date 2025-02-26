package com.example.Online.Examination.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Online.Examination.System.Model.Result;
import com.example.Online.Examination.System.Model.User;

public interface ResultRepository extends JpaRepository<Result, Long> {
	
	public List<Result> findByUser(User user);

}
