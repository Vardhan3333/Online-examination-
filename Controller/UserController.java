package com.example.Online.Examination.System.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Online.Examination.System.DTO.ResultDto;
import com.example.Online.Examination.System.DTO.UserDTO;
import com.example.Online.Examination.System.Model.QuestionBank;
import com.example.Online.Examination.System.Model.Result;
import com.example.Online.Examination.System.Model.Test;
import com.example.Online.Examination.System.Model.User;
import com.example.Online.Examination.System.Repository.ResultRepository;
import com.example.Online.Examination.System.Repository.TestRepository;
import com.example.Online.Examination.System.Repository.UserRepository;
import com.example.Online.Examination.System.Service.UserServiceImplimentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@Controller
public class UserController {
	
	@Autowired
	ResultRepository rrepo;
	
	@Autowired
	TestRepository trepo;
	
	@Autowired
	UserServiceImplimentation usimpli;
	
	@Autowired
	UserRepository urepo;
	
	int marks =0;
	int count=0;
	@GetMapping("/loginpage")
	public String login() {
		System.out.println("Hi");
		return "login";
	}
	
	
	@GetMapping("/Register")
	public String register() {
		System.out.println("regi");
		return "Registration";
	}
	@PostMapping("/registeration")
	public String resgistration(@ModelAttribute User user) {
		if(usimpli.save(user)) {
		return "Success";}
		return "failure";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam String emailId,@RequestParam String password,HttpSession session) {
		User user = usimpli.findUser(emailId);
		if(emailId.equals("RootAdmin") && emailId.equals("rootAdmin@123")) {
			return "Success2";
		}
		if(user!=null) {
			if(usimpli.check(user, password)) {
				if(user.getRole().equals("User")) {
					session.setAttribute("user", user);
					
					return "User";
				}
				else if(user.getRole().equals("Admin") && user.getStatus().equals("Accepted")) {
					session.setAttribute("user", user);
				return "admin";
				}
			}
		}
		return "Failure";
	}
	
	@GetMapping("/testsavailable")
	public String testsavailable(HttpSession session,org.springframework.ui.Model m) {
		if(session.getAttribute("user")==null) {
			return "login";
		}
		User user = (User)session.getAttribute("user");
		List<Test> list = trepo.findByGroup(user.getGroup());
		System.out.println(list);
		
		m.addAttribute("tests", list);
		return "testsavailable";
	}
	
	@PostMapping("/registerForTest")
	public String registerForTest(@RequestParam Long testId,HttpSession session ) {
		System.out.println(testId);
		List<Test> list = new ArrayList<Test>();
		System.out.println(testId);
		Test test = trepo.getById(testId);
		list.add(test);
		User user = (User)session.getAttribute("user");
		List<Test> userTests = user.getTest();

		// Check if the test is already in the list
		if (!userTests.contains(test)) {
		    userTests.add(test); // Add the test to the list if it's not already there
		}

		user.setTest(userTests); // Update the user's list of tests
		urepo.save(user);
		
		return "User";
	}
	
	@GetMapping("/upcomingTests")
	public String upcomingTests(HttpSession session,org.springframework.ui.Model m) {
		if(session.getAttribute("user")==null) {
			return "login";
		}
		User user = (User)session.getAttribute("user");
		List<Test> list = user.getTest();
		List<Test> list1 = new ArrayList<>();
		for(Test test : list) {
			if(!(LocalDate.now().isAfter(test.getDate()))) {
				list1.add(test);
			}
		}
		System.out.println(list1);
		
		m.addAttribute("tests", list1);
		return "upcomingtests";
	}
	
//	@GetMapping("/navigateToNextQuestion")
//	public String navigate(HttpSession session,@RequestParam String userAnswers) {
//		System.out.println(userAnswers);
////	List<QuestionBank> questions = (List<QuestionBank>)session.getAttribute("questions");
//		return "Test";
//		
//	}
	@GetMapping("/takeTest")
	public String takeTest(@RequestParam Long testId, org.springframework.ui.Model model, HttpSession session) {
		
	    // In a real application, fetch test questions from a database based on testId.
	    Test test = trepo.getById(testId);
	    session.setAttribute("stest", test);
	    List<Test> testt = new ArrayList<Test>();
	    testt.add(test);
	    session.setAttribute("test1", testt);
	    List<QuestionBank> questions = test.getQuestions(); // Replace with your database query
session.setAttribute("test", questions);
	    // Check if questions are not null and not empty before setting them in the session
	    if (questions != null && !questions.isEmpty()) {
	        // Initialize session variables
//	        session.setAttribute("questions", questions);
//	        session.setAttribute("currentQuestionIndex", 0);
	    	model.addAttribute("questions", questions);

	        return "Test";
	    } else {
	        // Handle the case where there are no questions for the given test
	        // You can redirect to an error page or take appropriate action.
	        return "errorPage"; // Replace with your error page view name
	    }
	}






//	 @GetMapping("/submitTest")
//	 public String submit(@RequestParam String userAnswers) {
//		 System.out.println(userAnswers);
//		 return "Success";
//	 }
	 
	@GetMapping("/submitTest")
	public String answers(HttpServletRequest request, HttpSession session, Model model) {
		if(session.getAttribute("test")==null) {
			return "User";
		}
	    Enumeration<String> answers = request.getParameterNames();
	    List<QuestionBank> questions = (List<QuestionBank>) session.getAttribute("test");
	    int marks = 0;
	    int count = 0;

	    while (answers.hasMoreElements()) {
	        String qno = answers.nextElement();
	        for (QuestionBank quess : questions) {
	            if (Long.toString(quess.getqId()).equals(qno)) {
	                if (quess.getCorrectAns().equals(request.getParameter(qno))) {
	                    marks++;
	                    count++;
	                }
	            }
	        }
	    }

	    Result result = new Result();
	    result.setMarks(marks);

	    if (marks > (0.4 * count)) {
	        result.setResult("pass");
	    } else {
	        result.setResult("fail");
	    }

	    result.setUser((User) session.getAttribute("user"));
	    Test test = (Test)session.getAttribute("stest");
	    Test test11 = new Test();
	    test11.setTestId(test.getTestId());
	    test11.setDate(test.getDate());
	    test11.setTime(test.getTime());
	    List<Test> testt = new ArrayList();
	    testt.add(test11);
	    
//	    List<Test> testt =(List<Test>)session.getAttribute("test1"); // Make sure "test" attribute contains a Test object
	    
	    System.out.println(testt);
	    result.setTest(testt);
	    rrepo.save(result);

	    
	    session.setAttribute("result", result.getResult());
	    session.setAttribute("marks", marks);
	    session.removeAttribute("test");
	    return "redirect:/result";
	}
	
	@GetMapping("/result")
	public String result(HttpSession session,Model model) {
		System.out.println("hi");
		model.addAttribute("result", (String)session.getAttribute("result"));
		model.addAttribute("marks",(int)session.getAttribute("marks"));
		return "result";
	}
	
	
	@GetMapping("/previousTests")
	public String previousTests(HttpSession session,Model model ) {
		if(session.getAttribute("user")==null) {
			return "login";
		}
		User user = (User)session.getAttribute("user");
		List<Result> result = rrepo.findByUser(user);
		List<ResultDto> previousTests = new ArrayList();
		for(Result r : result) {
			System.out.println(r);
			
			LocalDate date=LocalDate.now();
	for(Test t: r.getTest()) {
		date=t.getDate();
	}
	ResultDto result1 = new ResultDto(r.getMarks(),r.getResult(),date);
	previousTests.add(result1);
		}
		System.out.println(previousTests);
		model.addAttribute("results", previousTests);
		return "PreviousTests";
	}
	
	@GetMapping("/logout")
	public String Logout(HttpSession session,Model model) {
		session.invalidate();
		model.addAttribute("logout", "You have already loggedout");
		return "login";
	}
	
	@GetMapping("/userDetails")
	public String userDetails(HttpSession session,Model model) {
		User user = (User)session.getAttribute("user");
		UserDTO userdto = new UserDTO(user.getUserName(), user.getEmailId(), user.getAddress(), user.getPhoneNum(), user.getGroup());
		model.addAttribute("User", userdto)		;
		return "userDetails";
	}

	   
//	

}
