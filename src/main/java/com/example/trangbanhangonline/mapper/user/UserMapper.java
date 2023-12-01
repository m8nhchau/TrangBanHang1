package com.example.trangbanhangonline.mapper.user;

import com.example.trangbanhangonline.dto.requestDTO.user.UserRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.user.UserResponseDTO;
import com.example.trangbanhangonline.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntityUser(UserRequestDTO userRequestDTO);
    List<User> toEntityUserList(List<UserRequestDTO> userRequestDTOList);

    UserResponseDTO toResponseUser(User userNew);
    List<User> toResponseUserList(List<UserResponseDTO> userResponseDTOList);

}
