package com.clb.share.myApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clb.share.model.MyDemo;

@RestController
public class SecondAction {  
    @Autowired MyDemo demo;  
    
    @RequestMapping(value="second1",
            method=RequestMethod.GET,produces={"application/xml", "application/json"})  
    @ResponseStatus(HttpStatus.OK)
    public List<MyDemo> getDemo() {
    	List<MyDemo> list = new ArrayList<MyDemo>();
    	try{
    		for(int i=0;i<10;i++){
    			MyDemo demo = new MyDemo();
    			demo.setName("ÐÕÃû" + i);  
            	demo.setSex("ÄÐ"); 
            	demo.setWeigt(67.5+i*0.1);
            	demo.setHeugth(175.0+i*0.2);
            	list.add(demo);
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return list;
    }  
    
    @RequestMapping(value="second2",
            method=RequestMethod.GET,produces={"application/xml", "application/json"})  
    @ResponseStatus(HttpStatus.OK)
    public MyDemo getDemo2() {
    	MyDemo demo = new MyDemo();
    	try{
    		demo.setName("ÐÕÃû");  
            demo.setSex("ÄÐ"); 
            demo.setWeigt(67.5);
            demo.setHeugth(175.0);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return demo;
    } 
  
    @RequestMapping(value="second", method=RequestMethod.GET)  
    @ResponseStatus(HttpStatus.OK)  
    public String getDemoHtml() {  
        //Test HTML view  
        return "example";  
    }  
}  