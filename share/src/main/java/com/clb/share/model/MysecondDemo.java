package com.clb.share.model;

import org.springframework.stereotype.Component;

@Component("demo2")
public class MysecondDemo {

	private String secondName;
	
	private String secondFlag;

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getSecondFlag() {
		return secondFlag;
	}

	public void setSecondFlag(String secondFlag) {
		this.secondFlag = secondFlag;
	}
	
}
