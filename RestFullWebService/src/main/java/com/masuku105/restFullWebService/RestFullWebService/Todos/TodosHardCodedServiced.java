package com.masuku105.restFullWebService.RestFullWebService.Todos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodosHardCodedServiced {
	private static List<Todo> todos = new ArrayList();
	private static int idCounter=0;
	
	
	static {
		todos.add(new Todo(++idCounter,"Xolani","Learn to dance",new Date(),false));
		todos.add(new Todo(++idCounter,"Xolani","Learn about MicroService",new Date(),false));
		todos.add(new Todo(++idCounter,"Xolani","Learn Angular",new Date(),false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo saveTodo(Todo todo) {
		if(todo.getID()==-1 || todo.getID()==0) {
			todo.setID(++idCounter);
			todos.add(todo);
		}else {
			deleteTodo(todo.getID());
			todos.add(todo);
		}
		return todo;
	}
	
	public Todo deleteTodo(long id) {
		if(findById(id)!=null) {
			Todo todo = findById(id);
			todos.remove(todo);
			return todo;
		}else {
			return null;
		}
		
		
	}
	public Todo findById(long id) {
		for (Todo todo : todos) {
			if(todo.getID()==id) {
				return todo;
			}
		}
		return null;
	}
	

}
