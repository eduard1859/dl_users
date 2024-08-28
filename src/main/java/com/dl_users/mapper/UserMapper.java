package com.dl_users.mapper;

import com.dl_users.dto.UserDto;
import com.dl_users.dto.request.UserRequestDto;
import com.dl_users.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    User userDtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);
    User userRequestDtoToUser(UserRequestDto userRequestDto);
}
