package com.dl_users.controller;

import com.dl_users.dto.UserDto;
import com.dl_users.dto.request.UserRequestDto;
import com.dl_users.entity.User;
import com.dl_users.exception.ErrorResponse;
import com.dl_users.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequestDto userDto) {
        try {
            UserDto userDto1 = userService.registerUser(userDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(userDto1);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ErrorResponse("El correo ya registrado")
            );
        } catch (NoSuchAlgorithmException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                 new ErrorResponse( e.getMessage())
            );

        }
    }
}
