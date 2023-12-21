package com.gokul.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gokul.learnspringframework.helloworld.HelloWorldConfiguration;


public class App02HelloWorldSpring {

	public static void main(String[] args) {
		//1: Launch a Spring context
		try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			//2: Configure the things that we want spring to manage
			// HelloWorldConfiguration - @Configuration
			
			//3: Retrieving beans managed by Spring
			System.out.println(context.getBean("name"));

			System.out.println(context.getBean("age"));
			
			System.out.println(context.getBean("person"));
			
			System.out.println(context.getBean("address2"));
			
			System.out.println(context.getBean("address3"));
		
			System.out.println(context.getBean("person2MethodeCall"));
			
			System.out.println(context.getBean("person3Parameters"));
			
			// another way of retrieving bean using Class name
			//System.out.println(context.getBean(Address.class));
		}
		
		
		

	}

}
