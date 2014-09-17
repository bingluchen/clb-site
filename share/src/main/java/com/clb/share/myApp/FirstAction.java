package com.clb.share.myApp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstAction {

	@RequestMapping(value = "first")
	public String firstFunction(Model model){
		Map map = new HashMap();
		map.put("name0", "AQAQA");
		map.put("name1", "ERTR");
		model.addAttribute("modelname", map);
		return "/first/first";
	}
	
	@RequestMapping(value = "/first/upForm")
	public String upupup(String upName){
		System.out.println("AAAAAAAAAA"+upName);
		
		return "redirect:/first.sh";
	}
}
