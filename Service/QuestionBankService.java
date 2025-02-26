package com.example.Online.Examination.System.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Online.Examination.System.Model.QuestionBank;
import com.example.Online.Examination.System.Repository.QuestionBankRepository;
import com.example.Online.Examination.System.exception.Exception1;

@Service
public class QuestionBankService {

	@Autowired
	QuestionBankRepository qrepo;
	
	public List<QuestionBank> findAllByType(String type){
		List<QuestionBank> qb = new ArrayList<QuestionBank>();
		List<QuestionBank> q = qrepo.findAll();
		for(QuestionBank q1 : q) {
			if(q1.getType().equals(type)) {
				qb.add(q1);
			}
		}
		if(qb.isEmpty()) {
			throw new Exception1("the search has no result");
		}
		return qb;
	}
}
