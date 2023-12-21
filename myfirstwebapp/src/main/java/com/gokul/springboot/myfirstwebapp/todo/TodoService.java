package com.gokul.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	static List<Todo> todos = new ArrayList<Todo>();
	private static int todosCount = 1;
	static {
		todos.add(new Todo(todosCount++, "Gokul", "Learn SpringBoot", LocalDate.now().plusWeeks(1), false));
		todos.add(new Todo(todosCount++, "Gokul", "Learn LLD", LocalDate.now().plusWeeks(2), false));
		todos.add(new Todo(todosCount++, "Gokul", "Revise DSA", LocalDate.now().plusWeeks(4), false));
	}
	
	public List<Todo> findByUsername(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		todos.add(new Todo(todosCount++, username, description, targetDate, done)); 
	}
	
	public void deleteById(int id) {
		//Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf( todo -> todo.getId() == id);
	}

	public Todo findById(int id) {
		Todo todo = todos.stream()
				.filter(t -> t.getId() == id)
				.findFirst()
				.get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}

}
