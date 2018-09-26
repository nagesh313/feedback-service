package com.feedback.controller;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.entity.Feedback;
import com.feedback.service.FeedbackService;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@GetMapping
	public List<Feedback> getAllFeedbacks() {
		return feedbackService.getAllFeedback();
	}

	@PostMapping
	public Feedback saveFeedback(@RequestBody Feedback feedback) {
		return feedbackService.saveFeedback(feedback);
	}

}
