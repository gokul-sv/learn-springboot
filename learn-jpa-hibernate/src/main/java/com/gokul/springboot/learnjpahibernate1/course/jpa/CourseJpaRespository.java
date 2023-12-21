package com.gokul.springboot.learnjpahibernate1.course.jpa;

import org.springframework.stereotype.Repository;

import com.gokul.springboot.learnjpahibernate1.course.jdbc.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository // means this interacts with database
@Transactional // this is mandatory for perform DB operation/transactions
public class CourseJpaRespository {
	@PersistenceContext // for 
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
}
