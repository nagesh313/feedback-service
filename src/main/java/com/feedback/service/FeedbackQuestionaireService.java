package com.feedback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.entity.FeedbackQuestionaire;
import com.feedback.repository.FeedbackQuestionaireRepository;

@Service
public class FeedbackQuestionaireService {
	@Autowired
	private FeedbackQuestionaireRepository feedbackQuestionaireRepository;

	public FeedbackQuestionaire newFeedbackQuestionaire(FeedbackQuestionaire feedbackQuestionaire) {
		return feedbackQuestionaireRepository.save(feedbackQuestionaire);
	}

	public List<FeedbackQuestionaire> getAllFeedbackQuestionaire() {
		return feedbackQuestionaireRepository.findAll();
	}

	public List<FeedbackQuestionaire> getFeedbackQuestionaire(String feedbackQuestionaire) {
		return feedbackQuestionaireRepository.findByFeedbackQuestionaire(feedbackQuestionaire);
	}
}
