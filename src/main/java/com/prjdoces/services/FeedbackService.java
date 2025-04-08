package com.prjdoces.services;

import org.springframework.stereotype.Service;

import com.prjdoces.repositories.FeedbackRepository;

@Service
public class FeedbackService {
    
    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }
}
