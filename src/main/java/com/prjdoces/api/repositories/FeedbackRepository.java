package com.prjdoces.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjdoces.api.entities.Feedback;
import com.prjdoces.api.entities.Usuario;
public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
    List<Feedback> findByUsuario(Usuario usuario);
}
