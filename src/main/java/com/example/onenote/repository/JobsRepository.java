package com.example.onenote.repository;

import javax.annotation.Nullable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onenote.entity.Jobs;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Integer>{
//	@Nullable
//	Iterable<Jobs> findByRole(String job_role);
}
