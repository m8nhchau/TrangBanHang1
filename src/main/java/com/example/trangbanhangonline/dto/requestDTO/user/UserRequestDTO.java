package com.example.trangbanhangonline.dto.requestDTO.user;

import com.example.trangbanhangonline.enums.UserRoleEnum;
import lombok.Data;

import java.util.Date;

@Data
public class UserRequestDTO {
    private Integer userId;
    private String fullName;
    private Date birthday;
    private String phoneNumber;
    private String userName;
    private String address;
    private String email;
    private String password;
}
