package com.prjdoces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prjdoces.entities.Feedback;
public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
    
}
