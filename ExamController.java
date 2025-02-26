package com.example.Online.Examination.System.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Online.Examination.System.Model.QuestionBank;
import com.example.Online.Examination.System.Model.Result;
import com.example.Online.Examination.System.Model.Test;
import com.example.Online.Examination.System.Model.User;
import com.example.Online.Examination.System.Repository.ResultRepository;
import com.example.Online.Examination.System.Repository.TestRepository;

import javax.servlet.http.HttpSession;

@Controller
public class ExamController {
	
	@Autowired
	TestRepository trepo;
	
	@Autowired
	ResultRepository rrepo;
	
//	
}


	




