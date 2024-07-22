package com.ankit.springboot.restapi.webpage.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDao extends JpaRepository<TodoBean,Integer>{
 

}


