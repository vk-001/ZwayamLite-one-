package com.example.onenote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onenote.entity.Userlogin;
import com.sun.istack.Nullable;

public interface UserRepository extends JpaRepository< Userlogin, Integer> {
	@Nullable
	Userlogin findByEmail(String email);
	
}
