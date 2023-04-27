package com.example.surapi.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.surapi.model.persistance.RegistrationToken;

@Repository
public interface RegistrationTokenRepository extends JpaRepository<RegistrationToken, Long> {
    Optional<RegistrationToken> findByToken(String token);

    List<RegistrationToken> findBySystemUserId(Long userId);

    List<RegistrationToken> findByExpirationDateBefore(LocalDateTime date);
}
