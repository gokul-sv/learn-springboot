package com.gokul.springboot.learnjpahibernate1.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // means this interacts with database
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplet;
	private static String INSERT_QUERY = 
			"""
				insert into course values(?,?,?)

			""";
	
	private static String DELETE_QUERY = 
			"""
				delete from course where id=?

			""";
	
	private static String SELECT_QUERY = 
			"""
				select * from course where id=?

			""";
	
	public void insert(Course course) {
		springJdbcTemplet.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	
	public void deleteById(long id) {
		springJdbcTemplet.update(DELETE_QUERY, id);
	}
	
	public Course findById(long id) {
		// ResultSet -> Bean => RowMapper
		return springJdbcTemplet.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
