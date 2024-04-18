package com.controller;

import java.util.List;

import com.model.User;

public interface UserController {
	
	
	public boolean addUser(User u);//Create Operation
	
	public boolean userLogin(String un , String pwd);//Read Operation
	
	public List<User> getAllData(); //Read Operation
	
	
	public boolean deleteAUser(int id);	//Delete Operation
	
	
	public User getUserById(int id); //Read Operation

	
	
	public boolean editUser(User u);//Update Operation
}
