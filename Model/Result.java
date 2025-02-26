package com.example.Online.Examination.System.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class Result {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	
	@ManyToMany
	@JoinTable(
			name="test_result",
			joinColumns =@JoinColumn(name="result_id"),
			inverseJoinColumns = @JoinColumn(name="test_id"))
	private List<Test> Test = new ArrayList<>();
	
	private int marks;
	private String result;

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", user=" + user + ", Test=" + Test + ", marks=" + marks + ", result=" + result
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Test> getTest() {
		return Test;
	}

	public void setTest(List<Test> test) {
		Test = test;
	}
	

}
