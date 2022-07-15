package com.example.onenote.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class ApplicationId implements Serializable {
	
	private int app_id;
	private int job_id;
	
	
	
	public int getApp_id() {
		return app_id;
	}

	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public ApplicationId() { }
	
	public ApplicationId(int app_id, int job_id) {
		this.app_id = app_id;
		this.job_id = job_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + app_id;
		result = prime * result + job_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicationId other = (ApplicationId) obj;
		if (app_id != other.app_id)
			return false;
		if (job_id != other.job_id)
			return false;
		return true;
	}
	
	
}
