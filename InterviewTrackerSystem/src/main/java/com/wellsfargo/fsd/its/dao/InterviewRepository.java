package com.wellsfargo.fsd.its.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.its.entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer>{

	@Modifying
	@Query("update Interview i set i.interviewStatus = :interviewStatus where i.interviewId = :interviewId")
	void updateInterviewStatus(@Param("interviewId") int interviewId, @Param("interviewStatus") String interviewStatus);
	
	@Query("SELECT i FROM Interview i WHERE i.interviewName = :interviewName")
	List<Interview> searchByInterviewName(@Param("interviewName") String interviewName);
	
	@Query("SELECT i from Interview i WHERE i.interviewerName = :interviewerName")
	List<Interview> searchByInterviewerName(@Param("interviewerName") String interviewerName);
	
	
	
}
