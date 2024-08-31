package com.example.TechPlay.Repositary;

import com.example.TechPlay.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByUsername(String username);
    //implementation of findByUsername is provided automatically at runtime by framework.
    // Spring data JPA generates implementation at runtime.
}
