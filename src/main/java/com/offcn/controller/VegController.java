package com.offcn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.offcn.job.Job_Time;
import com.offcn.pojo.Vegetables;
import com.offcn.service.Veg_Service;

@Controller
@RequestMapping("oop")
public class VegController {

	@Autowired
	private Veg_Service veg_Service;
	
	@RequestMapping("saveData")
	public String saveData(){
		//从网页爬取数据
		Job_Time.setTime();
		System.out.println("数据爬取成功");
		//往数据库中存入数据
		List<Vegetables> list = veg_Service.javaPoi();
		if(list.size() != 0){
			return "success";
		}
		return "fail";
	}
	
	/*public String paChong(){
		Job_Time.setTime();
	}*/
}
