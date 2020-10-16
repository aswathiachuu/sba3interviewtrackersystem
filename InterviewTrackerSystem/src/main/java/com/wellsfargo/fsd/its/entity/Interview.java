package com.wellsfargo.fsd.its.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Interview implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Interview() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int interviewId;
	
	@NotNull
	@Size(min = 5, max = 30)
	private String interviewerName;
	@NotNull
	@Size(min = 3, max = 30)
	private String interviewName;
	
	@NotNull
	@Size(min = 5, max = 30)
	private String userSkills;
	private LocalTime time;
	private LocalDate date;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String interviewStatus;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String remarks;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "interviews")
	@JsonIgnoreProperties("interviews")
	private Set<User> users = new HashSet<User>();
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public int getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}
	public String getInterviewerName() {
		return interviewerName;
	}
	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}
	public String getInterviewName() {
		return interviewName;
	}
	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}
	public String getUserSkills() {
		return userSkills;
	}
	public void setUserSkills(String userSkills) {
		this.userSkills = userSkills;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getInterviewStatus() {
		return interviewStatus;
	}
	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Interview(int interviewId, String interviewerName, String interviewName, String userSkills, LocalTime time,
			LocalDate date, String interviewStatus, String remarks) {
		super();
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.userSkills = userSkills;
		this.time = time;
		this.date = date;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
	}
}
