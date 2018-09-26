package com.feedback.helper;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.feedback.entity.Feedback;
import com.feedback.service.FeedbackService;

@Component
public class FeedbackBot {
	
	@Value("${app.default.feedback.id}")
	private String feedbackId;
	
	@Autowired
	private FeedbackService feedbackService;

	@Scheduled(fixedDelay = 1000000)
	public void createRandomFeedback() {
		Feedback feedback = new Feedback(feedbackId, "This is a bot generated comment at " + new Date().toString(),
				Integer.valueOf((int) Math.random() * 10), "STAR");
		feedbackService.saveFeedback(feedback);
	}
}
