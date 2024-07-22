package com.ankit.springboot.restapi.webpage.todo;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

//@Component
@Entity
@Table(name="todolist")
public class TodoBean {
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=10 ,message="Atleast 10 Charaters")
	@Column
	private	String description;
	@Column
	private LocalDate date;
	@Column
	private boolean flag;
	
	public TodoBean()
	{	
		System.out.print("constructor calling");
	}
	public TodoBean(int id, String description, LocalDate date, boolean flag) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.flag = flag;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public boolean getFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	
	
	
	@Override
	public String toString() {
		return "TodoBean [id=" + id + ", description=" + description +"  flag=" + flag + "]";
	}
	
	
}



