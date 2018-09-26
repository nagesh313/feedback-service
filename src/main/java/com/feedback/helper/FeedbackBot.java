package com.feedback.helper;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.feedback.entity.Feedback;
import com.feedback.entity.FeedbackQuestionaire;
import com.feedback.service.FeedbackQuestionaireService;
import com.feedback.service.FeedbackService;

@Component
public class FeedbackBot {

	@Value("${app.default.feedback.id1}")
	private String feedbackId1;
	@Value("${app.default.feedback.id2}")
	private String feedbackId2;
	@Value("${app.default.feedback.id3}")
	private String feedbackId3;
	@Autowired
	private FeedbackService feedbackService;

	@Autowired
	private FeedbackQuestionaireService feedbackQuestionaireService;

	@PostConstruct
	public void insertQuestioniares() {
		FeedbackQuestionaire feedbackQuestionaire = new FeedbackQuestionaire();
		feedbackQuestionaire.setFeedbackQuestionaire(feedbackId1);
		feedbackQuestionaire.setQuestion("How do you like this App?");
		feedbackQuestionaire.setType("SMILEY");
		feedbackQuestionaireService.newFeedbackQuestionaire(feedbackQuestionaire);
		feedbackQuestionaire = new FeedbackQuestionaire();
		feedbackQuestionaire.setFeedbackQuestionaire(feedbackId2);
		feedbackQuestionaire.setQuestion("Rate our App?");
		feedbackQuestionaire.setType("STAR");
		feedbackQuestionaireService.newFeedbackQuestionaire(feedbackQuestionaire);
		feedbackQuestionaire = new FeedbackQuestionaire();
		feedbackQuestionaire.setFeedbackQuestionaire(feedbackId3);
		feedbackQuestionaire.setQuestion("Like our App?");
		feedbackQuestionaire.setType("LIKE");
		feedbackQuestionaireService.newFeedbackQuestionaire(feedbackQuestionaire);
	}

	private int idToTake = 0;

	@Scheduled(fixedDelay = 10000)
	public void createRandomFeedback() {
		Feedback feedback = new Feedback(idToTake(), "This is a bot generated comment at " + new Date().toString(),
				(int) (Math.random() * 10));
		feedbackService.saveFeedback(feedback);
	}

	private String idToTake() {
		idToTake++;
		if (idToTake % 3 == 0) {
			return feedbackId1;
		} else if (idToTake % 3 == 1) {
			return feedbackId2;
		} else {
			return feedbackId3;
		}
	}

}
