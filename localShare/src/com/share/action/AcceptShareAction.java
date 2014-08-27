package com.share.action;

import jcifs.smb.SmbFile;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.common.BaseAction;

@Namespace("/share")
public class AcceptShareAction extends BaseAction{
	
	private String ftpDress;
	private String userName;
	private String passWord;
	
	/**
	 * 处理ftp文件
	 */
	@Action(value = "shareMyFtp")
	public void shareFtp(){
		//smb://xxx:xxx@192.168.2.188/testIndex/  
        //xxx:xxx是共享机器的用户名密码
		StringBuffer url=new StringBuffer("");
		if(!StringUtils.isEmpty(userName)){
			url.append("smb://").append(userName).append(":").append(passWord).append("@").append(ftpDress);
		}else{
			url.append("smb://").append(ftpDress);
		}
		try{
	        SmbFile file = new SmbFile(url.toString());
	        if(file.exists()){
	            SmbFile[] files = file.listFiles();
	            for(SmbFile f : files){
	                System.out.println(f.getName());
	            }
	        }
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		System.out.println("QQQQQ"+ftpDress);
	}

	
	
	
	
	public String getFtpDress() {
		return ftpDress;
	}
	public void setFtpDress(String ftpDress) {
		this.ftpDress = ftpDress;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
