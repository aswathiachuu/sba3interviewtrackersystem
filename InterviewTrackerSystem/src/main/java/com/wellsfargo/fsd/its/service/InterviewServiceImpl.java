package com.wellsfargo.fsd.its.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wellsfargo.fsd.its.dao.InterviewRepository;
import com.wellsfargo.fsd.its.dao.UserRepository;
import com.wellsfargo.fsd.its.entity.Interview;
import com.wellsfargo.fsd.its.entity.User;

@Service
public class InterviewServiceImpl implements InterviewService {
	
	@Autowired
	InterviewRepository interviewRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Interview addInterview(Interview interview) {
		
		return interviewRepository.save(interview);
	}

	@Override
	public String deleteInterview(int interviewId) {
		String response = null;
		if(interviewRepository.existsById(interviewId)) {
		
		interviewRepository.deleteById(interviewId);
		response = "interview deleted";
		}
		
		else {
			response = "interview not found";
		}
		return response;

	}

	@Override
	@Transactional
	public void updateInterviewStatus(int interviewId, String interviewStatus) {
		// TODO Auto-generated method stub
		interviewRepository.updateInterviewStatus(interviewId, interviewStatus);
	}

	@Override
	public List<Interview> findbyInterviewName(String interviewName) {
		return interviewRepository.searchByInterviewName(interviewName);
	}

	@Override
	public List<Interview> findbyInterviewerName(String interviewerName) {
		return interviewRepository.searchByInterviewerName(interviewerName);
	}

	@Override
	public int findInterviewCount() {
		return (int) interviewRepository.count();
	}

	@Override
	public List<Interview> displayAllInterviews() {
		return interviewRepository.findAll();
	}

	@Override
	public Boolean addAttendee(int userId, int interviewId) {
		
	Interview interview = interviewRepository.findById(interviewId).get();;
	User user = userRepository.findById(userId).get();
	
	if(!interview.getUsers().contains(user)) {
		interview.getUsers().add(user);
		user.getInterviews().add(interview);
		interviewRepository.save(interview);
		return true;
	}
	else {
		return false;
	}
	
		
	}

	@Override
	public Set<User> showAllAttendeesByInterview(int interviewId) {
		
		return interviewRepository.findById(interviewId).get().getUsers();
	}
}
