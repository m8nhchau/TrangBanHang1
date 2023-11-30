package com.example.trangbanhangonline.service;


import com.example.trangbanhangonline.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface SessionService {
    User validate(String sessionCode);
}
