package com.example.onenote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.onenote.entity.Userlogin;
import com.example.onenote.userservice.UserService;
  


@RestController 
@CrossOrigin
public class controller {
	
	@Autowired
	UserService service;

	@GetMapping("/")
	public String home(){
		return "Welcome to Home Screen";
	}
	
	@PostMapping("/createAccount")
	public String CreateAccount (@RequestBody Userlogin userlogin){
		
		String currEmail = userlogin.getEmail();
		
		if(isValid(currEmail))
		{
			if(service.getUserByEmail(currEmail)==null)
			{
				service.SaveUser(userlogin);  
				return "Account created";
			}else {
				return "Account already Exists";
			}
		}
		return "Enter valid credentials";
		
    }
	
	public boolean isValid(String email) {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	   }
	
	
	@PostMapping("/userlogin")
	@ResponseBody
	public String Authentication(@RequestBody Userlogin templogin) {
		
		
		String tempEmail = templogin.getEmail();
		String tempPwd = templogin.getPwd();
		try {
			Userlogin userlogin = service.getUserByEmail(tempEmail);
			
			if(userlogin!=null)
			{	
				if(tempPwd.equals(userlogin.getPwd()))
				{
					service.getUserByEmail(tempEmail);
					return "Login Successful";
				}
				
				else
					return "Invalid Credentials";
			}		
		}
		catch(NullPointerException e) { }
		return "Account does not exists";
				 
		
		
	}
	
	
	@GetMapping("/users")
	public List<Userlogin> findAllUsers(){
		return service.getUsers();
	}
	
	@GetMapping("/users/id/{id}")
	public Userlogin findUserById(@PathVariable int id) {
		return service.getUserById(id);
	}
	
	@GetMapping("/users/email/{email}")
	public Userlogin findByEmail(@PathVariable String email) {
		return service.getUserByEmail(email);
	}
	
	@PutMapping("/updateUser")
	public Userlogin updateUser(@RequestBody Userlogin userlogin) {
		return service.SaveUser(userlogin);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}
}
