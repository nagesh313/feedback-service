package com.feedback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String feedbackQuestionaireId;
	private String comment;
	private Integer rating;

	public Feedback() {
		super();
	}

	public Feedback(String feedbackQuestionaireId, String comment, Integer rating) {
		super();
		this.feedbackQuestionaireId = feedbackQuestionaireId;
		this.comment = comment;
		this.rating = rating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFeedbackQuestionaireId() {
		return feedbackQuestionaireId;
	}

	public void setFeedbackQuestionaireId(String feedbackQuestionaireId) {
		this.feedbackQuestionaireId = feedbackQuestionaireId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
