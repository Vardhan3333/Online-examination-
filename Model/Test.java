package com.example.Online.Examination.System.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long testId;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="test_question",
			joinColumns =@JoinColumn(name="test_id"),
			inverseJoinColumns = @JoinColumn(name="question_id"))
	private List<QuestionBank> questions = new ArrayList<QuestionBank>();
	
	@Column(name = "user_group")
	private String group;
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public List<QuestionBank> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionBank> questions) {
		this.questions = questions;
	}
	private LocalDate date;
	private LocalTime time;
	public Long getTestId() {
		return testId;
	}
	public void setTestId(Long testId) {
		this.testId = testId;
	}
	
	
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Test [testId=" + testId + ", questions=" + questions + ", group=" + group + ", date=" + date + ", time="
				+ time + "]";
	}
	
	
	
	

}
