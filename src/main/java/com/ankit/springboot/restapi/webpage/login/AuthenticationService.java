package com.ankit.springboot.restapi.webpage.login;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
	public boolean loginCheck(String name,String password) {
		return name.equalsIgnoreCase("Ankit")&&password.equalsIgnoreCase("Ankit");
	}
}

