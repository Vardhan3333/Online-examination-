package com.example.Online.Examination.System.DTO;

import javax.persistence.Column;

public class UserDTO {
	
	private String userName;
	public UserDTO(String userName, String emailId, String address, Long phoneNum, String group) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.address = address;
		this.phoneNum = phoneNum;
		this.group = group;
	}
	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", emailId=" + emailId + ", address=" + address + ", phoneNum="
				+ phoneNum + ", group=" + group + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	private String emailId;
	private String address;
	private Long phoneNum;
	private String group; 

}
