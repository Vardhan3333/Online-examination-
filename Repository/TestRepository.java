package com.example.Online.Examination.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Online.Examination.System.Model.Test;



public interface TestRepository extends JpaRepository<Test, Long> {
	
	public List<Test> findByGroup(String group);

}
