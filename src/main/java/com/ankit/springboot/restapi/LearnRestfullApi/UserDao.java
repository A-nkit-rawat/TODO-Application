package com.ankit.springboot.restapi.LearnRestfullApi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserDao {
	private static int index=0;
	private List<User> listOfUsers=new ArrayList<User>(Arrays.asList(new User(++index,"Anuu",LocalDate.now().plusYears(2))) );
	
	
	public List<User> findAll(){
		return listOfUsers;
	}
	
	
	public User addUsers(User newUser) {
		newUser.setId(++index);
		listOfUsers.add(newUser);
		return newUser;
	}
	
	public User findById (int id) {
		for(User ele:listOfUsers) {
			if(ele.getId()==id) return ele;
		}
		return null;
			
	}
	
	public void deleteById(int id) {
		for(User ele:listOfUsers) {
			if(ele.getId()==id) listOfUsers.remove(ele);
		}
		System.out.println("inside for loop");
	}
	
	
	
}
