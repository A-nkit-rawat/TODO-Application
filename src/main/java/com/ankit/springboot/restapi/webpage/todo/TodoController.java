package com.ankit.springboot.restapi.webpage.todo;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class TodoController {
	
	@Autowired
	private TodoService todoservice;
//	@Autowired
//	private TodoDao abc;
	
//	private List<TodoBean> todoLists;
	@RequestMapping(name="/")
	public String home() {
		return "redirect:todo-list";
	}
	
	
	@RequestMapping("/todo-list")
	public String todoMethod(ModelMap model) {
		

		model.addAttribute("todoLists",todoservice.getTodoList());
		return "todoList";
	}
	@RequestMapping(value="/todo", method=RequestMethod.GET)
	public String addTodo(ModelMap model) {
//		System.out.print(name);
		TodoBean todo=new TodoBean(0,"Set Goal",LocalDate.now().plusYears(1),false);
		model.addAttribute("todo",todo);
		return "addTodo";
	}
	@RequestMapping(value="/todo" ,method=RequestMethod.POST)
	public String showAddedTodo( @ModelAttribute("todo") @Valid TodoBean todo, BindingResult result) {
		
		
		if(result.hasErrors()) {
			return "addTodo";
		}
		
		todoservice.addTodo(todo);
		return "redirect:todo-list";
	}
	@RequestMapping(value="/delete-todo" ,method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoservice.deleteTodo(id);
		return "redirect:todo-list";
	}
	@RequestMapping(value="/update-todo", method=RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id ,ModelMap model) {
		model.addAttribute("todo",new TodoBean(id,"",LocalDate.now(),false));
		
		return "updateTodo";
	}
	@RequestMapping(value="/update-todo", method=RequestMethod.POST)
	public String updateTodo(@ModelAttribute("todo") @Valid TodoBean todo) {
		
		todoservice.updateTodo(todo);
		return "redirect:todo-list";
	}
	
}
