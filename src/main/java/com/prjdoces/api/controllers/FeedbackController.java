package com.prjdoces.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjdoces.api.entities.Feedback;
import com.prjdoces.api.entities.Usuario;
import com.prjdoces.api.services.FeedbackService;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {
    
    private final FeedbackService feedbackService;
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    // Métodos
    
    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback){
        Feedback savedFeedback = feedbackService.saveFeedback(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFeedback);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id){
        if(feedbackService.getFeedbackById(id)!= null){
            feedbackService.deleteFeedback(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    } 

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks(){
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/usuario/{usuario}")
	public ResponseEntity<List<Feedback>> getTelefoneByUsuario(@PathVariable("usuario") Usuario usuario) {
		List<Feedback> feedback = feedbackService.getFeedbackByUsuario(usuario); // Ajuste o método no serviço
		if (feedback != null) {
			return ResponseEntity.ok(feedback);
		} else {
			return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar
		}
	}
}
