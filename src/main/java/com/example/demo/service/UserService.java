package com.example.demo.service;

import java.util.List;

import com.example.demo.beans.User;


public interface UserService {
	//Method for Adding user detail
	public void addUserDetail (User u);
	
	// Methods to show all users
	public List<User> showwAllUser();
	// Method to show user with their username
	public List<User> showUser(String name);
	// Method to delete Data
	public void deleteData(int id);
	// Search user method
	public User SearchUser(int userid);
	// Login using email
	public User login(String email);
	//register using email
	public String register(String email);
	 //Update data of the users
	public void updateUserDetail (User u);
}
