package com.ankit.springboot.restapi.Internationalization;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnotherController {
	
	@Autowired
	MessageSource msg;
	
	@GetMapping("/hello/{name}")
	public String helloWithParameter(@PathVariable(name="name") String name) {
		return String.format("Hello World %s", name);
		
	}
	
	@GetMapping("/hello-world")
	public String i18n() {
		Locale locale= LocaleContextHolder.getLocale();
		return msg.getMessage("good.morning.message", null,"default message", locale);
		
	}
	
}
