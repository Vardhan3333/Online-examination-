package com.example.Online.Examination.System.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Online.Examination.System.Model.QuestionBank;
import com.example.Online.Examination.System.Model.Test;
import com.example.Online.Examination.System.Model.User;
import com.example.Online.Examination.System.Repository.QuestionBankRepository;
import com.example.Online.Examination.System.Repository.TestRepository;
import com.example.Online.Examination.System.Service.QuestionBankService;
import com.example.Online.Examination.System.Service.UserServiceImplimentation;

@Controller
public class MainController {
	
	@Autowired
	TestRepository trepo;
	
	@Autowired
	QuestionBankRepository qbank;
	
	@Autowired
	QuestionBankService qservice;
	
	@Autowired
	QuestionBankRepository qrepo;
	
	@Autowired
	UserServiceImplimentation usimpli;
	
	@GetMapping("/adminreg")
	public String Hi() {
		return "adminreg";
	}
	@PostMapping("/adminregister")
	public String adminRegister(@ModelAttribute User user) {
		if(usimpli.saveAdmin(user)) {
		return "login";}
		return "login";
	}
	
	@PostMapping("/savetest")
	public String saveTest(@RequestParam Long Id,@RequestParam String type,@RequestParam String testDate,
            @RequestParam String testTime) {
		System.out.println("test");
		LocalDate parsedDate = LocalDate.parse(testDate);
        LocalTime parsedTime = LocalTime.parse(testTime);
		Test test = new Test();
		if(trepo.existsById(Id)) {
			test = trepo.getById(Id);
		}
		List<QuestionBank> questions = qservice.findAllByType(type);
		Collections.shuffle(questions);
		List<QuestionBank> selectedQuestions = questions.subList(0, Math.min(questions.size(), 10));
		List<QuestionBank> qb = test.getQuestions();
		qb.addAll(selectedQuestions);
		test.setQuestions(qb);
		test.setDate(parsedDate);
		test.setTime(parsedTime);
		trepo.save(test);
		return "admin";
	}
	
	
	@GetMapping("/getquestions")
	public String getQuestions(@RequestParam Long Id,Model m) {
		Test test = trepo.getById(Id);
		List<QuestionBank> qb = test.getQuestions();
		m.addAttribute("questions", qb);
		return "Success";
	}
	
	@GetMapping("/addquestion")
	public String addQuestionTable() {
		return "addquestion";
	}
	
	@GetMapping("/addtest")
	public String addTest() {
		return "addtest";
	}
	
	@PostMapping("/savequestion")
	public Object addQuestion(@ModelAttribute QuestionBank question) {
		qrepo.save(question);
		return question;
		
	}
	
	@GetMapping("/getallquestions")
		public List<QuestionBank> getAllQuestions(){
		System.out.print(qrepo.findAll());
		System.out.println("hi");
		return qrepo.findAll();
	}
	
	@PostMapping("/updatequestion")
	public QuestionBank updateQuestion(@RequestParam Long Id,@RequestBody QuestionBank questions){
		QuestionBank qbank = qrepo.getById(Id);
		qbank.setqDesc(questions.getqDesc());
		qbank.setCorrectAns(questions.getCorrectAns());
		qbank.setMarks(questions.getMarks());
		qbank.setOp1(questions.getOp1());
		qbank.setOp2(questions.getOp2());
		qbank.setOp3(questions.getOp3());
		qbank.setType(questions.getType());
		qrepo.save(qbank);
		return qrepo.save(qbank);
	}
	
	@PutMapping("/updatetest")
	public String updateTest(@RequestParam Long Id,@RequestBody Test test) {
		System.out.println(test.getDate());
		Test test1 = trepo.getById(Id);
		if(test1!=null) {
		test1.setTime(test.getTime());
		test1.setQuestions(test.getQuestions());
		test1.setDate(test.getDate());
		trepo.save(test1);
		System.out.println(trepo.save(test1));
		return "Success";}
		return "Failure";
	}
	
	@DeleteMapping("/deletetest")
	public String deleteTest(@RequestParam Long Id) {
		trepo.deleteById(Id);
		return "Success";
	}
	
	@DeleteMapping("/deletequestion")
	public String deleteQuestion(@RequestParam Long Id) {
		qrepo.deleteById(Id);
		return "Success";
	}
	
}