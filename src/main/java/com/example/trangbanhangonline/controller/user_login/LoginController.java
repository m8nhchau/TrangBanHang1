package com.example.trangbanhangonline.controller.user_login;

import com.example.trangbanhangonline.dto.requestDTO.LoginDTO;
import com.example.trangbanhangonline.dto.responseDTO.UserResponseDTO;
import com.example.trangbanhangonline.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@AllArgsConstructor
@SessionAttributes("userDTO")
public class LoginController {
    private final UserService userService;
    @ModelAttribute("userDTO")
    public UserResponseDTO userDTO(){
        return new UserResponseDTO();
    }
    @GetMapping("/login")
    public String showLoginForm(){
        return "/login";
    }

    @PostMapping("/login")
    public ResponseEntity<String> Login(@RequestBody LoginDTO loginDTO) throws NoSuchAlgorithmException {

        return ResponseEntity.ok(userService.login(loginDTO));
    }

}
