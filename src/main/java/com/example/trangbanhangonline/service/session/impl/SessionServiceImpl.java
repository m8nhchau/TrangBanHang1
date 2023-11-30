package com.example.trangbanhangonline.service.session.impl;

import com.example.trangbanhangonline.entity.Session;
import com.example.trangbanhangonline.entity.User;
import com.example.trangbanhangonline.repository.session.SessionRepository;
import com.example.trangbanhangonline.service.session.SessionService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    @Override
    public User validate(String sessionCode) {

        if (StringUtils.isBlank(sessionCode)) {
            throw new RuntimeException("sessionCode khong de trong!");
        }
        Optional<Session> session = sessionRepository.findBySessionCode(sessionCode);
        if(!session.isPresent()){
            throw new RuntimeException("sessionCode khong ton tai!");
        }

        Date now = new Date();
        if(now.after(session.get().getExpiredDate())){
            throw new RuntimeException("Phiên đăng nhập đã hết hạn!");
        }

        return session.get().getUser();
    }
}
