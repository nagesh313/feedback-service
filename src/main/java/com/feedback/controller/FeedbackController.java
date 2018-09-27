package com.feedback.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.entity.Feedback;
import com.feedback.entity.FeedbackQuestionaire;
import com.feedback.service.FeedbackQuestionaireService;
import com.feedback.service.FeedbackService;

@RestController
@CrossOrigin
@RequestMapping("/api/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	@Autowired
	private FeedbackQuestionaireService feedbackQuestionaireService;

	@GetMapping
	public List<Feedback> getAllFeedbacks() {
		return feedbackService.getAllFeedback();
	}

	@GetMapping("/questions")
	public List<FeedbackQuestionaire> getAllFeedbackQuestionaire() {
		return feedbackQuestionaireService.getAllFeedbackQuestionaire();
	}

	@GetMapping("/questions/{id}")
	public FeedbackQuestionaire getFeedbackQuestionaireById(@PathVariable String id) {
		return feedbackQuestionaireService.getFeedbackQuestionaire(id).get();
	}

	@PostMapping("/submit")
	public Feedback saveFeedback(@RequestBody Feedback feedback) {
		return feedbackService.saveFeedback(feedback);
	}

}
