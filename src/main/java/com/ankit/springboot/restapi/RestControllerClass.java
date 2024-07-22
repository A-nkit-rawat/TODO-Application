package com.ankit.springboot.restapi;

//import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestControllerClass {
	 
	
	@RequestMapping("/course")
	public List<Courses> restapi(){ 
		return Arrays.asList(new Courses(1,"Learn Spring","Ankit"), new Courses(2,"Learn React","Manish and Ankit"));
	}
	
	
}
