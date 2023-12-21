package com.gokul.springboot.learnjpahibernate1.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gokul.springboot.learnjpahibernate1.course.jdbc.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{
	
	// below are the custom method - we must follow a naming convention
		// -> findBy and then followed by the attribute(Course class) names (i.e findByAuthor or findByName)
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
}
