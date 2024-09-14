//WDF Module
//CONTROLLER of ABCComunnity 
//by Eliazer J. C. Loelan

package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.beans.User;
import com.example.demo.dao.UserDao;
import com.example.demo.security.ApplicationUserDetail;
import com.example.demo.service.UserService;

@Controller
public class ProductController {
	@Autowired
	UserService userService;
	List<User> ShowUser = new ArrayList<User>();
	UserDao DaoUser;
	
	//index
	@GetMapping(value = "/")
	public String landingPage() {
		return "LandingPage";
	}
	
	
	//register
	@GetMapping(value = "/register")
	public String register(@ModelAttribute("data")User user) {
		return "Register";
	}
	@PostMapping(value = "/emailverify")
	public String emailVerify(ModelMap model, @ModelAttribute("data")User user, @RequestParam String email) {
		String emailRegisterString = userService.register(email);
		System.out.println(emailRegisterString);
		if(emailRegisterString.equals("0")) {
			userService.addUserDetail(user);
			System.out.println(user);
			model.addAttribute("sendEmail", email);
			return "EmailConfirmation";
		} else {
			model.addAttribute("ExistEmail", "*Email already registered*");
			return "Register";
		}
	}
	@GetMapping(value = "/thankyou")
	public String thankYou() {
		return "ThankYouRegister";
	}
	
	
	// Login
	@GetMapping(value = "/logins")
	public String login() {
			//@ModelAttribute("data")User user){
		System.out.println("in login method");
		//Model model, String error, String logout) {
//		System.out.println(model+error+" "+logout);
//		if(error != null) {
//            System.out.println(error);
//            model.addAttribute("errorLogin", "Your email or password is wrong");
//        }
		return "Login";
	}
	
	// Login
		@PostMapping(value = "/loginUser")
		public String loginUser(@ModelAttribute("data")User user){
			System.out.println("in userLogin"+user);
			//Model model, String error, String logout) {
//			System.out.println(model+error+" "+logout);
//			if(error != null) {
//	            System.out.println(error);
//	            model.addAttribute("errorLogin", "Your email or password is wrong");
//	        }
			return "Home";
		}
		
	// Forget password
	@GetMapping(value = "/forgetpassword")
	public String forgetPassword() {
		return "ForgetPassword";
	}
	@GetMapping(value = "/forgetverify")
	public String forgetVerify() {
		return "ForgetVerify";
	}
	@GetMapping(value = "/resetpassword")
	public String resetPassword() {
		return "ResetPassword";
	}
	
	
	//Home
	@GetMapping(value = "/home")
	public String home(@AuthenticationPrincipal ApplicationUserDetail userDet, HttpSession session) {
		String email = userDet.getUsername();
		User us= userService.login(email);
		
		session.setAttribute("id_user", us.getId_user());
		session.setAttribute("role", us.getRole());
		session.setAttribute("username", us.getUsername());
		session.setAttribute("email", us.getEmail());
		session.setAttribute("fname", us.getFirstName());
		session.setAttribute("lname", us.getLastName());
		session.setAttribute("address", us.getAddress());
		session.setAttribute("contact", us.getContact());
		session.setAttribute("password", us.getPassword());
		
		return "Home";
	}
	 
	
	//Search Profile
	@GetMapping(value = "/searchprofile")
	public String searchProfile() {
		return "ViewProfile";
	}
	@PostMapping(value = "/profilesearch")
	public ModelAndView profileSearch(@ModelAttribute("singleProfile")User user) {
		String searchname=user.getUsername();
		List<User> uu=userService.showUser(searchname);
		
	return new ModelAndView("SearchProfile","testS", uu);
	}
	@PostMapping(value = "/userprofilesearch")
	public ModelAndView userProfileSearch(@ModelAttribute("singleProfile")User user) {
		String searchname=user.getUsername();
		List<User> uu=userService.showUser(searchname);
		
	return new ModelAndView("UserSearch","testS", uu);
	}
	
	
	// Show All User Profile
	@GetMapping(value = "/viewprofile")
	public ModelAndView viewProfile(@ModelAttribute("singleProfile")User user) {
		List<User> udata= userService.showwAllUser();
		System.out.println(udata);
		return new ModelAndView("ViewProfile", "testV", udata);
	}
	
	@GetMapping(value = "/userviewprofile")
	public ModelAndView userViewProfile(@ModelAttribute("singleProfile")User user) {
		List<User> udata= userService.showwAllUser();
		System.out.println(udata);
		return new ModelAndView("UserViewProfile", "testV", udata);
	}
	
	
	//Delete
	@GetMapping(value = "/deleted/{id_user}")
	public String deleteUser (@PathVariable("id_user")Integer id) {
		userService.deleteData(id);
		return "redirect:/viewprofile";
	}
	
	
	//Update Profile
	@GetMapping(value = "/update/{id_user}")
	public ModelAndView update(@PathVariable("id_user")Integer id) {
		User u=userService.SearchUser(id);
		return new ModelAndView ("UpdateProfile", "viewProfile", u);
	}
	
	@GetMapping(value = "/update/dataupdate")
	public String updateData(@RequestParam("uId")Integer  id,
		@RequestParam("uUsername") String username,
		@RequestParam("uEmail") String email,
		@RequestParam("uFirstName") String firstName,
		@RequestParam("uLastName") String lastName,
		@RequestParam("uPassword") String password,
		@RequestParam("uAddress") String address,
		@RequestParam("uContact") String contact,	
		@RequestParam("uRole")String role) {
		
		System.out.println(id+" "+username + " " + "Updated");
		User u=new User(id, username, email, firstName, lastName, password, address, contact, role);
		userService.updateUserDetail(u);

		return "redirect:/home";
	}
	
	//ViewOwnProfile
	@GetMapping(value = "/updateprofile")
	public String updateProfile() {
		return "UserUpdateProfile";
	}
}


