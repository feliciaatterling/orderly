package com.felicia.studyapp.repositories;
import java.util.Optional;

import com.felicia.studyapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); // Custom query example 
    
}
