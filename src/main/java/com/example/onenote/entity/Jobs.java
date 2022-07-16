package com.example.onenote.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Jobs")
public class Jobs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int job_id;
	
	@Column(nullable = false)
	private String job_role;
	
	@Column(nullable = false)
	private String job_desc;
	
	@Column(nullable = false)
	private int rec_id;
	
	
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getJob_role() {
		return job_role;
	}
	public void setJob_role(String job_role) {
		this.job_role = job_role;
	}
	public String getJob_desc() {
		return job_desc;
	}
	public void setJob_desc(String job_desc) {
		this.job_desc = job_desc;
	}
	public int getRec_id() {
		return rec_id;
	}
	public void setRec_id(int rec_id) {
		this.rec_id = rec_id;
	}
	
	public Jobs() {
		
	}
	
	public Jobs(String job_role, String job_desc, int rec_id) {
		this.job_role = job_role;
		this.job_desc = job_desc;
		this.rec_id = rec_id;
	}
}
