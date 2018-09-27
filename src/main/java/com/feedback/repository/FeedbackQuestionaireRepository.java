package com.feedback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.feedback.entity.FeedbackQuestionaire;

@Repository
public interface FeedbackQuestionaireRepository extends JpaRepository<FeedbackQuestionaire, String> {
	@Query("SELECT t FROM FeedbackQuestionaire t where t.feedbackQuestionaire = :feedbackQuestionaire") 
    List<FeedbackQuestionaire> findByFeedbackQuestionaire(@Param("feedbackQuestionaire") String feedbackQuestionaire);
}
