package com.gokul.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SayHelloController {
	// say-hello => Hello! what are you learning today?
	
	@RequestMapping("say-hello")
	@ResponseBody // if we want return the object as it is we have use this
	public String sayHello() {
		return "Hello! what are you learning today?";
	}
	

	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>")
		.append("<head>")
		.append("<title>HTML Page</title>")
		.append("</head>")
		.append("<body>My First HTML page from SpringBoot</body>")
		.append("</html>");
		return sb.toString();
	}
	
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
}
