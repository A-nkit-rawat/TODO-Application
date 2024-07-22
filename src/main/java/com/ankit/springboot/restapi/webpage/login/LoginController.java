package com.ankit.springboot.restapi.webpage.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@Autowired
	private AuthenticationService authenticationService;
	@RequestMapping("/login")
	public String login() {
		return "loginPage";
	}
	
	@RequestMapping("/submission")
	public String authentication(@RequestParam("name") String name, @RequestParam("password") String password ,ModelMap model) {
		
		model.put("name",name);
		model.put("password",password);
//		System.out.println("not working");
		Boolean flag=authenticationService.loginCheck(name, password);
		if(flag) {
			return "welcomePage";
		}
		return "loginPage";
	}
}
