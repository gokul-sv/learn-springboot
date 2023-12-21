package com.gokul.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
	//private TodoService todoService;
	
	private TodoRepository todoRepository;
	
	public TodoControllerJpa(TodoRepository todoRepository) {
		super();
		//this.todoService = todoService;
		this.todoRepository = todoRepository;
	}



	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		
		String username = getLoggedInUsername();
		model.put("todos", todoRepository.findByUsername(username));
		
		
		return "listTodos";
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {	
		String username = getLoggedInUsername();
		Todo todo = new Todo(0, username, "",  LocalDate.now().plusWeeks(5), false);
		model.put("todo", todo);
		return "todo";
	}



	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewTodoPage( ModelMap model, @Valid Todo todo, BindingResult result) {	
		if (result.hasErrors()) {
			return "todo";
		}
		String username = getLoggedInUsername();
		todo.setUsername(username);
		todoRepository.save(todo);
		//todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		//todoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateTodoPage( ModelMap model, @Valid Todo todo, BindingResult result) {	
		if (result.hasErrors()) {
			return "todo";
		}
		String username = getLoggedInUsername();
		todo.setUsername(username);
		todoRepository.save(todo);
		//todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
}
