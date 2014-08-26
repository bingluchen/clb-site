package com.share.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.common.BaseAction;

@Namespace("/share")
public class AcceptShareAction extends BaseAction{
	
	private String ftpDress;
	
	@Action(value = "shareMyFtp")
	public void shareFtp(){
		System.out.println("QQQQQ"+ftpDress);
	}

	
	
	
	
	public String getFtpDress() {
		return ftpDress;
	}

	public void setFtpDress(String ftpDress) {
		this.ftpDress = ftpDress;
	}
}
