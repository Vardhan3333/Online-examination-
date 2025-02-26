package com.example.Online.Examination.System.Model;

import java.util.List;

import javax.persistence.*;

@Entity
public class QuestionBank {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qId;
	private String qDesc;
	private String op1;
	private String op2;
	private String op3;
	private String correctAns;
	private String type;
	
	
	
//	@ManyToOne
//	@JoinColumn(name="test")
//	private Test test;
	
//	public Test getTest() {
//		return test;
//	}
//	public void setTest(Test test) {
//		this.test = test;
//	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private Integer marks;
	@Override
	public String toString() {
		return "QuestionBank [qId=" + qId + ", qDesc=" + qDesc + ", op1=" + op1 + ", op2=" + op2 + ", op3=" + op3
				+ ", correctAns=" + correctAns + ", type=" + type + ",  marks=" + marks + "]";
	}
	public Long getqId() {
		return qId;
	}
	public void setqId(Long qId) {
		this.qId = qId;
	}
	public String getqDesc() {
		return qDesc;
	}
	public void setqDesc(String qDesc) {
		this.qDesc = qDesc;
	}
	public String getOp1() {
		return op1;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public String getOp2() {
		return op2;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public String getOp3() {
		return op3;
	}
	public void setOp3(String op3) {
		this.op3 = op3;
	}
	public String getCorrectAns() {
		return correctAns;
	}
	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	

}
