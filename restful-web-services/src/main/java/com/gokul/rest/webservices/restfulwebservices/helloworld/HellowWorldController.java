package com.gokul.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowWorldController {
	
	private MessageSource messageSource;
	
	public HellowWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@GetMapping(path="/hellow-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hellow-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	
	@GetMapping(path="/hellow-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello World, "+ name);
	}

	
	@GetMapping(path="/hellow-world-internationalized")
	public String helloWorlinternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Defalt Message", locale);
		// return "Hello World V2";
	}
}
