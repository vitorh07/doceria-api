package com.prjdoces.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjdoces.api.services.FeedbackService;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {
    
    private final FeedbackService feedbackService;
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }
}
