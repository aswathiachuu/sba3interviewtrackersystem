package com.wellsfargo.fsd.its.service;

import java.util.List;
import java.util.Set;

import com.wellsfargo.fsd.its.entity.Interview;
import com.wellsfargo.fsd.its.entity.User;

public interface InterviewService {
	
	public Interview addInterview(Interview interview);
	
	public String deleteInterview(int interviewId);
	
	public void updateInterviewStatus(int interviewId, String interviewStatus);
	
	public List<Interview> findbyInterviewName(String interviewName);
	
	public List<Interview> findbyInterviewerName(String interviewerName);
	
	public int findInterviewCount();
	
	public List<Interview> displayAllInterviews();
	
	public Boolean addAttendee(int interviewId, int userId);
	
	public Set<User> showAllAttendeesByInterview(int interviewId);


	
	
}
