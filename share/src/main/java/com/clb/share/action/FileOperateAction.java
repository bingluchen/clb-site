package com.clb.share.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileOperateAction {

	private static final String FILEFORDE = "/fileoperate/";
	
	@RequestMapping(value = "localhostShare")
	public String operateFile(){
		
		return "localhostShare";
	}
}
