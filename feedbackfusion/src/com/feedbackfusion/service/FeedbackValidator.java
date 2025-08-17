package com.feedbackfusion.service;

import com.feedbackfusion.model.Feedback;

/**
 * A validator class for Feedback data. It contains all business rules for
 * ensuring data integrity before persistence.
 */
public class FeedbackValidator {

    /**
     * Validates a feedback object to ensure it meets business criteria.
     * @param feedback The Feedback object to validate.
     * @throws IllegalArgumentException if the feedback data is invalid.
     */
    public void validate(Feedback feedback) throws IllegalArgumentException {
        if (feedback.getRating() < 1 || feedback.getRating() > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
        if (feedback.getFeedbackType() == null || feedback.getFeedbackType().trim().isEmpty()) {
            throw new IllegalArgumentException("Feedback type cannot be empty.");
        }
    }
}