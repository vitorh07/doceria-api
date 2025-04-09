package com.prjdoces.api.services;

import org.springframework.stereotype.Service;

import com.prjdoces.api.repositories.FeedbackRepository;

@Service
public class FeedbackService {
    
    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }
}
