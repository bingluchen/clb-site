package com.clb.share.myApp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstAction {

	//model����
	@RequestMapping(value = "first1")
	public String firstFunction(Model model){
		Map map = new HashMap();
		map.put("name0", "name0");
		map.put("name1", "name1");
		model.addAttribute("modelname", map);
		return "first/first";
	}
	
	//������·����(����һ����)
	@RequestMapping("first1/{name}")
	public String firstFunction1(@PathVariable String name){
		System.out.println("name is "+name);
		
		return "redirect:/first1.sh";
	}
	
	/*//������·����(���ֲ�һ����)
	@RequestMapping("first1/{name}")
	public String firstFunction2(@PathVariable("name") String ccname){
		System.out.println("name2 is " + ccname);
		return "redirect:/first.sh";
	}*/
	
	//ֱ�Ӵ�����
	@RequestMapping(value="/first2",params="name=firstFunction3")
	public String firstFunction3(String name){
		System.out.println("this name is " + name);
		return "redirect:/first1.sh";
	}
	
	//post�ύ
	@RequestMapping(value = "/first/upForm")
	public String upupup(String upName){
		System.out.println("AAAAAAAAAA"+upName);
		return "redirect:/first1.sh";
	}
}
