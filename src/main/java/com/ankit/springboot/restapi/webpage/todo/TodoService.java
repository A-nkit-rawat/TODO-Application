package com.ankit.springboot.restapi.webpage.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;



@Service
public class TodoService {
	
	@Autowired
	private TodoDao todoDao;
	
	
	
	//--- before DataBase
	
	
//	private static int index=0;
//	private static List<TodoBean> todoLists=new ArrayList<>(Arrays.asList(new TodoBean(++index,"Learn BootStrap",LocalDate.ofYearDay(2024, 24),false)
//				,new TodoBean(++index,"Learn React",LocalDate.ofYearDay(2024, 02),true)));
	
////	static
////	{
//////		LocalDate.now();
////		todoLists=Arrays.asList(new TodoBean(++index,"Learn BootStrap",LocalDate.ofYearDay(2024, 24),false)
////				,new TodoBean(++index,"Learn React",LocalDate.ofYearDay(2024, 02),true));
////	}
	
	
	
	//--BeforeDataBAse
	
	
	public  List getTodoList() {
		return todoDao.findAll();
		
		
//		return todoLists;
	}
	public  void addTodo(TodoBean todo) {
//		todo.setId(++index);
		todo.setFlag(false);
		todoDao.save(todo);
		
		
		
		
		
//		System.out.println("Working 25+465146513516516521");
//		TodoBean newBean=new TodoBean(++index,description,LocalDate.now().plusYears(1),false);
		
		//Descrption dependency is already set by user
	
//		todo.setDate(LocalDate.now().plusYears(1));
		
		
		
		
//		todoLists.add(todo);
		
	}
	
	
	public  void deleteTodo(int id) {
		
		todoDao.deleteById(id);
		
		
//		for(var item:todoLists) {
//			if(item.getId()==id) {
//				todoLists.remove(item);
//				return ;
//			}
//		}
		
		
	}
	
	public  void updateTodo(TodoBean todo) {
		
		todoDao.save(todo);
		
		
//		for(var item:todoLists) {
//			if(item.getId()==todo.getId()) {
////				deleteTodo(id);
//				item.setDescription(todo.getDescription());
//				item.setDate(todo.getDate());
//				item.setFlag(todo.getFlag());
//				return;
//			}
//		}
	}
	}	



