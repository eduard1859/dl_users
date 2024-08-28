package com.dl_users.service.imp;

import com.dl_users.dto.UserDto;
import com.dl_users.dto.request.UserRequestDto;
import com.dl_users.entity.User;
import com.dl_users.mapper.UserMapper;
import com.dl_users.repository.UserRepository;
import com.dl_users.service.IUserService;
import com.dl_users.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;



    public User getUserByEmail(String email) {
            return userRepository.findByEmail(email);
        }

    @Override
    public UserDto registerUser(UserRequestDto userRequestDto) throws NoSuchAlgorithmException {
            User user = UserMapper.INSTANCE.userRequestDtoToUser(userRequestDto);
            user.setToken(generateJwtToken(userRequestDto));
            user.getPhones().forEach(phone -> phone.setUser(user));
             return UserMapper.INSTANCE.userToUserDto(userRepository.save(user));

    }

        @Override
        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

       private String encryptPassword(String password) {
            return password;
        }

         private String generateJwtToken(UserRequestDto userRequestDto) throws NoSuchAlgorithmException {
             JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
            return  jwtTokenUtil.generateToken(userRequestDto);
        }

}
