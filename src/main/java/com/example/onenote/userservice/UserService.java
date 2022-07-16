package com.example.onenote.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onenote.entity.Userlogin;
import com.example.onenote.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired 
	private UserRepository repo;
	
	public Userlogin SaveUser(Userlogin userlogin) {
		return repo.save(userlogin);
	}
	
	public List<Userlogin> getUsers(){
		return repo.findAll();
	}
	
	public Userlogin getUserById(int id){
		return repo.findById(id).orElse(null);
	}
	
	public Userlogin getUserByEmail(String email){
		return repo.findByEmail(email);
	}
	
	
	public String deleteUser(int id) {
		repo.deleteById(id);
		return "Removed User with id "+id;
	}
	
	

	public Userlogin updateUser(Userlogin userlogin) {
		Userlogin existingUser = repo.findById(userlogin.getId()).orElse(null);
		existingUser.setFirstname(userlogin.getFirstname());
		existingUser.setLastname(userlogin.getLastname());
		existingUser.setEmail(userlogin.getEmail());
		existingUser.setPwd(userlogin.getPwd());
		
		return repo.save(existingUser);
	}


}
