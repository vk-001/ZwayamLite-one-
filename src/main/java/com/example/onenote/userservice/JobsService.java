package com.example.onenote.userservice;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onenote.entity.Jobs;
import com.example.onenote.repository.JobsRepository;

@Service
public class JobsService {

//	@Autowired
//	private JobsRepository jobsRepository;
	
//	//to register the job
//	public Jobs addJobs(Jobs jobs) {
//		return jobsRepository.save(jobs);
//	}
//	
//	//find job by the job_id
//	public Optional<Jobs> getJobById(Integer job_id) {
//		return jobsRepository.findById(job_id);
//	}
//	
//	//find job by the job_role
//	public Iterable<Jobs> getJobByRole(String job_role) {
//		return jobsRepository.findByRole(job_role);
//	}
//	
//	//to delete jobs by job_id
//	public String deleteJobById(Integer job_id) {
//		jobsRepository.deleteById(job_id);
//		return "Job has been deleted successfully!!!";
//	}
//	
}
