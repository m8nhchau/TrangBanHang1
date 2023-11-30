package com.example.trangbanhangonline.repository.session;

import com.example.trangbanhangonline.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
    Optional<Session> findByUser_UserId(Integer userId);
    Optional<Session> findBySessionCode(String sessionCode);

}
