package com.wellsfargo.fsd.its.controller;

import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.its.entity.User;
import com.wellsfargo.fsd.its.service.InterviewService;
import com.wellsfargo.fsd.its.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	InterviewService interviewService;
	
	@GetMapping("/listusers")
	public ResponseEntity<List<User>> listUsers(){
		
		return new ResponseEntity<List<User>>(userService.displayAllUsers(), HttpStatus.OK); 
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<String> addUser(@Valid @RequestBody User newUser){
	String response = null;
	if(newUser !=null) {
	userService.addUser(newUser);	
	response ="user added";
	}
	else {
		response ="user details not valid";
	}
	return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteuser/{userid}")
	public ResponseEntity<String> deleteuser(@PathVariable int userid){
		String response = userService.deleteUser(userid);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	
	@PostMapping("/addusertointerview/{userId}/{interviewId}")
	public ResponseEntity<String> addUserToInterview(@PathVariable int userId, @PathVariable int interviewId){
		String response = null;
		if(interviewService.addAttendee(userId, interviewId)) {
			response = "user added";
		}
		else {
			response = "user already exists";
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
		
	}
	
	@GetMapping("/showattendeebyinterview/{interviewId}")
	public ResponseEntity<Set<User>> showAttendeebyInterview(@PathVariable int interviewId){
		
		return new ResponseEntity<Set<User>>(interviewService.showAllAttendeesByInterview(interviewId),HttpStatus.OK);
	}
	
}
