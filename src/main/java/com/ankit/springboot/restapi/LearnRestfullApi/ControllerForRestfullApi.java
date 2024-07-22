	package com.ankit.springboot.restapi.LearnRestfullApi;

import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.dialect.function.array.ArraysOfSameTypeArgumentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class ControllerForRestfullApi {
	
	@Autowired
	private UserDao userdao;
	
	@GetMapping(path="/users")
	public List<User> getList(){
		return userdao.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
//		System.out.print(id);
		
		 User findById = userdao.findById(id);
		 if(findById==null) throw new UserNotFoundException("id:"+id);
		 return findById;	
	}
	
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		System.out.println("working delete function"+id);
		userdao.deleteById(id);
	}
	
	
	@PostMapping(path="/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		
		
		
		System.out.print(user+"==============");
		 User addedUser=userdao.addUsers(user);
		//user/=> 
		URI loc=ServletUriComponentsBuilder
				//user/
				.fromCurrentRequest()
				//user/{id}
				.path("/{id}")
				//user/3	3 is just for example
				.buildAndExpand(addedUser.getId())
				//changing to uri
				.toUri();
		return ResponseEntity.created(loc).build();
	}
	
	
}
