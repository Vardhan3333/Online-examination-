package com.example.Online.Examination.System.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class ResultDto {
	
	private int marks;
	private String result;
	private LocalDate date;
	public ResultDto(int marks, String result, LocalDate date) {
		super();
		this.marks = marks;
		this.result = result;
		this.date = date;
	}
	@Override
	public String toString() {
		return "ResultDto [marks=" + marks + ", result=" + result + ", date=" + date + "]";
	}
	

}
