package com.prjdoces.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prjdoces.api.entities.Feedback;
import com.prjdoces.api.entities.Usuario;
import com.prjdoces.api.repositories.FeedbackRepository;

@Service
public class FeedbackService {
    
    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    // Métodos
    public Feedback saveFeedback(Feedback feedback){
        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(Long id){
        feedbackRepository.deleteById(id);
    }

    public Feedback getFeedbackById(Long id){
        return feedbackRepository.findById(id).orElse(null);
    }

    public List<Feedback> getAllFeedbacks(){
        return feedbackRepository.findAll();
    }

    public List<Feedback> getFeedbackByUsuario(Usuario usuario){
        return feedbackRepository.findByUsuario(usuario);
    }
}
