 package com.example.onenote.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor 
@Table(name="application")

//@IdClass(ApplicationId.class)


public class Application {
	
//	@Id
//	private int app_id;
//	@Id
//	private int job_id;
	@EmbeddedId
	private ApplicationId appl_id;
	private boolean status;
	
	
	public ApplicationId getAppl_id() {
		return appl_id;
	}
	public void setAppl_id(ApplicationId appl_id) {
		this.appl_id = appl_id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	public Application() {
		// TODO Auto-generated constructor stub
	}
	
	public Application(ApplicationId appl_id, boolean status) {
		this.appl_id = appl_id;
		this.status = status;
	}
	
	
	
	
	        
	
	 
	
	
	
}
