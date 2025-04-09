package com.prjdoces.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prjdoces.api.entities.Feedback;
public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
    
}
