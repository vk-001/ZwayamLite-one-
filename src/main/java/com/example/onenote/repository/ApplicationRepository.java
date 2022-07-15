package com.example.onenote.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.onenote.entity.Application;
import com.example.onenote.entity.ApplicationId;
import com.sun.istack.Nullable;

public interface ApplicationRepository extends JpaRepository<Application, ApplicationId>{

	@Nullable
	List<Application> findAllByStatus(boolean status);
	
	@Query("select a from Application a where job_id=?#{[0]}")
	List<Application> findjobs(Integer job_id);

	@Query("select a from Application a where job_id=?#{[0]} and status=?#{[1]} ")
	List<Application> findByJob_idAndStatus(Integer job_id, boolean status);

	@Query("select a from Application a where app_id=?#{[0]}")
	List<Application> findByApp_id(Integer app_id);
	
//	@Query("select a from Application a where job_id=?#{[0]} and status=?#{[1]} ")
//	List<Application> findByJob_idAndStatus(Integer job_id, boolean status);
	

}
