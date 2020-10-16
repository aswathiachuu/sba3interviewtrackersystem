package com.wellsfargo.fsd.its.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.its.entity.Interview;
import com.wellsfargo.fsd.its.entity.User;
import com.wellsfargo.fsd.its.service.InterviewService;

@RestController
public class InterviewController {
	
	@Autowired
	InterviewService interviewService;
	
	@GetMapping("/interview")
	public ResponseEntity<List<Interview>> displayAllInterviews(){
		
		return new ResponseEntity<List<Interview>>(interviewService.displayAllInterviews(),HttpStatus.OK);
	
	}
	
	@PostMapping("/addinterview")
	public ResponseEntity<String> addInterview(@Valid @RequestBody Interview newInterview){
	String response = null;
	if(newInterview != null) {
		interviewService.addInterview(newInterview);		
		response = "interview added";
	}
	else {
		response = "interview details not valid";
	}
	return new ResponseEntity<String>(response,HttpStatus.OK);
	}

	@DeleteMapping("/deleteinterview/{interviewid}")
	public ResponseEntity<String> deleteinterview(@PathVariable int interviewid){
		String response = interviewService.deleteInterview(interviewid);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@GetMapping("/interviewcount")
	public ResponseEntity<Integer> interviewCount(){
		
		return new ResponseEntity<Integer>(interviewService.findInterviewCount(),HttpStatus.OK);
	}
	
	@PutMapping("/updateinterviewstatus/{interviewId}/{interviewStatus}")
	public ResponseEntity<Interview> updateInterviewStatus(@PathVariable int interviewId, @PathVariable String interviewStatus){
		
		interviewService.updateInterviewStatus(interviewId, interviewStatus);
		return new ResponseEntity<Interview>(HttpStatus.OK);
	}
	
	@GetMapping("/searchInterview/{interviewName}")
	public ResponseEntity<List<Interview>> searchByInterviewName(@PathVariable String interviewName){
		
		return new ResponseEntity<List<Interview>>(interviewService.findbyInterviewName(interviewName),HttpStatus.OK);
	}
	
	@GetMapping("/searchInterviewer/{interviewerName}")
	public ResponseEntity<List<Interview>> searchByInterviewerName(@PathVariable String interviewerName){
		
		return new ResponseEntity<List<Interview>>(interviewService.findbyInterviewerName(interviewerName),HttpStatus.OK);
	}
} 
