package com.clb.share.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement
public class MyDemo {

	private String name;
	
	private String sex;
	
	private double weigt;
	
	private double heugth;

	public String getName() {
		return name;
	}
	
	@XmlAttribute 
	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	@XmlAttribute 
	public void setSex(String sex) {
		this.sex = sex;
	}

	public double getWeigt() {
		return weigt;
	}

	@XmlAttribute 
	public void setWeigt(double weigt) {
		this.weigt = weigt;
	}

	public double getHeugth() {
		return heugth;
	}

	@XmlAttribute 
	public void setHeugth(double heugth) {
		this.heugth = heugth;
	}
	
}
