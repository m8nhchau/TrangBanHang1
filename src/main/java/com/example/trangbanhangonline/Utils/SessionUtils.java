package com.example.trangbanhangonline.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@Slf4j
public class SessionUtils {

    @Value("${secret.key}")
    private String secretKey;

    private static SessionUtils sessionUtils = null;

    public static SessionUtils getInstance(){
        if(sessionUtils == null){
            sessionUtils = new SessionUtils();
        }
        return sessionUtils;
    }

    public String generateSession(String customKey) throws NoSuchAlgorithmException {
        String checkSum = secretKey + customKey;
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(checkSum.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();

        StringBuilder hexString = new StringBuilder();

        for (byte b : digest) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

//    public static void main(String[] args) throws NoSuchAlgorithmException {
//        String checkSum = "124@q";
//        MessageDigest md = MessageDigest.getInstance("SHA-1");
//        md.update(checkSum.getBytes(StandardCharsets.UTF_8));
//        byte[] digest = md.digest();
//
//        StringBuilder hexString = new StringBuilder();
//
//        for (byte b : digest) {
//            hexString.append(String.format("%02x", b));
//        }
//        log.info("Session code = {}", hexString);
//    }

}
