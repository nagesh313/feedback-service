package com.feedback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.entity.Feedback;
import com.feedback.repository.FeedbackRepository;

@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;

	public Feedback saveFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	public List<Feedback> getAllFeedback() {
		return feedbackRepository.findAll();
	}

}
