package com.gokul.springboot.learnjpahibernate1.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gokul.springboot.learnjpahibernate1.course.jdbc.Course;
import com.gokul.springboot.learnjpahibernate1.course.jpa.CourseJpaRespository;
import com.gokul.springboot.learnjpahibernate1.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRespository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
// below is for spring JDBC and JPA
//		// insert
//		repository.insert(new Course(1, "Learn Spring", "Gokul"));
//		repository.insert(new Course(2, "Learn Springboot", "Gokul"));
//		repository.insert(new Course(3, "Learn JPA", "Gokul"));
//		// delete
//		repository.deleteById(1);
//		// retrieve
//		System.out.println(repository.findById(2));
//		System.out.println(repository.findById(3));
		
		
		// below is for Spring Data JPA
		// insert
		repository.save(new Course(1, "Learn Spring", "Gokul"));
		repository.save(new Course(2, "Learn Springboot", "Gokul"));
		repository.save(new Course(3, "Learn Spring Data JPA", "Gokul"));
		// delete
		repository.deleteById(1l);
		// retrieve
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		// Useful inbuilt methods
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		// Custom methods defined in the CourseSpringDataJPA interface
		System.out.println(repository.findByAuthor("Gokul"));
		System.out.println(repository.findByAuthor(" "));
		
		System.out.println(repository.findByName("Learn Spring Data JPA"));
		
		
	}

}
