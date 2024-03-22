package com.fatimetou.patient.repositories;

import com.fatimetou.patient.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT NEW com.fatimetou.patient.entities.User(u.id, u.nom, u.prenom, u.email, u.password) FROM User u WHERE u.email = :email")
    Optional<User> findUserByEmail(@Param("email") String email);
}
