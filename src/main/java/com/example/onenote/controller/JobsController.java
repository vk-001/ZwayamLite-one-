package com.example.onenote.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.onenote.entity.Jobs;
import com.example.onenote.repository.JobsRepository;
import com.example.onenote.userservice.JobsService;

import java.util.*;
@RestController
@CrossOrigin
public class JobsController {
	
	@Autowired
	private JobsRepository jobsRepository;
	
	@GetMapping("/home/jobs")
	public String home() {
		return "Welcome to home page of jobs";
	}
	@PostMapping("/jobs")
	public String createJobs(@RequestBody Jobs jobs) {
		jobsRepository.save(jobs);
		return "The Job has been created successfully!!!";		
	}
	
	@GetMapping("/job/{id}")
	public Optional<Jobs> viewJobs(@PathVariable Integer id){
		return jobsRepository.findById(id);
	}
	
	@GetMapping("/jobs")
	public List<Jobs> getJobs(){
		return jobsRepository.findAll();
	}
	
//	@GetMapping("/job/{role}")
//	public Iterable<Jobs> viewJobsList(@PathVariable String role){
//		return jobsRepository.findByRole(role);
//	}
	
	
	@DeleteMapping("/jobs/delete/{id}")
    public String deleteJobs(@PathVariable Integer id) {
        jobsRepository.deleteById(id);
        return "The Job has been deleted successfully";
    }
	
}