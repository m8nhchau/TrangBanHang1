package com.example.trangbanhangonline.dto.responseDTO;

import com.example.trangbanhangonline.enums.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO implements Serializable {

    private Integer userId;
    private String fullName;
    private Date birthday;
    private String phoneNumber;
    private String userName;
    private String address;
    private UserRoleEnum userRole;
}