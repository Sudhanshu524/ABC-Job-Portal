//Service to do Action

package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.beans.User;
import com.example.demo.dao.UserDao;


@Service("userservice")
public class UserServiceImplement implements UserService{
	private PasswordEncoder passwordencoder;
	@Autowired
	UserDao DaoUser;
	
	List<User> myAllUsers = new ArrayList<User>();
	
	@Autowired
	public UserServiceImplement(PasswordEncoder encoder) {
		// TODO Auto-generated constructor stub
		this.passwordencoder=encoder;
	}
	@Override
	public void addUserDetail(User u) {
		// TODO Auto-generated method stub
		u.setRole("USER"); //Auto role for new register
		u.setPassword(passwordencoder.encode(u.getPassword())); //Encode password to bcrypt
		DaoUser.save(u);	//To add record to the database table
	}

	@Override
	public List<User> showwAllUser() {
		// TODO Auto-generated method stub
		List<User> allDatabase=DaoUser.findAll();
		return allDatabase;
	}

	@Override
	public List<User> showUser(String name) {
		// TODO Auto-generated method stub
		return DaoUser.findByUsernameContaining(name);	
	}

	@Override
	public void deleteData(int id) {
		// TODO Auto-generated method stub
		DaoUser.deleteById(id);
	}

	@Override
	public User SearchUser(int userid) {
		// TODO Auto-generated method stub
		Optional<User> userData = DaoUser.findById(userid);
		User d = userData.get();
		return d;
	}

	@Override
	public User login(String email) {
		// TODO Auto-generated method stub
		User userLogin = DaoUser.findByEmail(email);
		return userLogin;
	}

	@Override
	public String register(String email) {
		// TODO Auto-generated method stub
		String userRegister = DaoUser.register(email);
		return userRegister;
	}
	
	@Override
	public void updateUserDetail(User u) {
		// TODO Auto-generated method stub
		//myAllUsers.add(u);
		DaoUser.save(u);	//To add record to the database table
	}
	
}
