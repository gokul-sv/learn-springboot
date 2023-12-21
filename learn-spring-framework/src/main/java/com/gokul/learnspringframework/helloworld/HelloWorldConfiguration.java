package com.gokul.learnspringframework.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age, Address address) {};

record Address (String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {
	
	
	@Bean
	public String name() {
		return "Gokul";
	}
	
	@Bean
	public int age() {
		return 26;
	}
	
	@Bean
	public Person person() {
		return new Person("Dhoni", 42, new Address("Ranchi", "Jharkhand"));
	}
	
	
	// creating person bean with use of existing beans methods by using methods
	// method name should match (name(), age(), address())
	@Bean
	public Person person2MethodeCall() {
		return new Person(name(), age(), address());
	}
	
	// creating person bean with use of existing beans by passing as parameter
	// parameter name should match with the bean name (name, age, address2)
	@Bean
	public Person person3Parameters(String name, int age, Address address2) {
		return new Person(name, age, address2);
	}
	
	// custom name for bean
	@Bean(name="address2")
	public Address address() {
		return new Address("Puliyankurichi", "Salem");
	}
	
	@Bean(name="address3")
	public Address addressNew() {
		return new Address("Attur", "Salem");
	}
	
}
