package com.example.onenote.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.Tomcat.ExistingStandardWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onenote.entity.Application;
import com.example.onenote.entity.ApplicationId;
import com.example.onenote.repository.ApplicationRepository;


@RestController
//@RequestMapping("/application")
public class ApplicationController {

	@Autowired
	private ApplicationRepository applicationRepository;
	
	@GetMapping("/test")
	public String Test() {
		return "Application runs Successfully";
	}
	
	// Posting an application
	@PostMapping("/application")
	public Application applications(@RequestBody Application app) {
		return applicationRepository.save(app);
	}
	
	// List of all applications
	@GetMapping("/list")
	public List<Application> listofallApplications(){
		return applicationRepository.findAll();
	}
	
	// To get candidates by status
	@GetMapping("/applicantStatus/{status}")
	public List<Application> applicants(@PathVariable boolean status) {
		return applicationRepository.findAllByStatus(status);
	}
	
	// To get applicants for a particular job
	@GetMapping("/applicants/{job_id}")
	public List<Application> ListofApplicants(@PathVariable Integer job_id){
		return applicationRepository.findjobs(job_id);
	}
	
	
	//List of selected applicants for a job_ib
	@GetMapping("selected/{job_id}/{status}")
	public List<Application> listofSelectedApplicants(@PathVariable Integer job_id, 
			@PathVariable boolean status){
		return applicationRepository.findByJob_idAndStatus(job_id,status);
	}
	
	//List of selected applicants for a job_ib
	@GetMapping("applied/{app_id}")
	public List<Application> listofAppliedJobs(@PathVariable Integer app_id){
		return applicationRepository.findByApp_id(app_id);
	}
		
	
}
