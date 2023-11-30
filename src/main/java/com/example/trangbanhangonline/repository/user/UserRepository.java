package com.example.trangbanhangonline.repository.user;

import com.example.trangbanhangonline.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByEmail(String email);

    User findUserByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    @Query(value = "select * from user ", nativeQuery = true)
    List<User> getAllUser();

    List<User> findUserByUserId(Integer userId);
}
