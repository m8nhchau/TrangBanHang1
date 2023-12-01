package com.example.trangbanhangonline.mapper.user;

import com.example.trangbanhangonline.dto.responseDTO.user.UserResponseDTO;
import com.example.trangbanhangonline.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    List<UserResponseDTO> toResponseUserList(List<User> userList);
}
