package com.dl_users.service;

import com.dl_users.dto.UserDto;
import com.dl_users.dto.request.UserRequestDto;
import com.dl_users.entity.User;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface IUserService {
    UserDto registerUser(UserRequestDto userDto) throws NoSuchAlgorithmException;

    List<User> getAllUsers();
}
