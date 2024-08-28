package com.dl_users.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.dl_users.dto.PhoneDto;
import com.dl_users.dto.UserDto;
import com.dl_users.dto.request.UserRequestDto;
import com.dl_users.service.imp.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
     void testRegisterUserSuccess() throws Exception {
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setName("Carlos");
        userRequestDto.setPassword("Password1!");
        userRequestDto.setEmail("eduard1831@gmail.com");

        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setCityCode("9");
        phoneDto.setCountryCode("+56");
        phoneDto.setNumber("1234567");

        userRequestDto.setPhones(List.of(phoneDto));

        UserDto userDto = new UserDto();
        userDto.setEmail("eduard1831@gmail.com");

        //when(userService.registerUser(any(UserRequestDto.class))).thenReturn(userDto);

        mockMvc.perform(post("/api/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequestDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("eduard1831@gmail.com"));
    }

    @Test
     void testRegisterUserBadRequest() throws Exception {
        UserRequestDto userRequestDto = new UserRequestDto();

        //when(userService.registerUser(any(UserRequestDto.class))).thenThrow(new RuntimeException("Email already registered"));

        mockMvc.perform(post("/api/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequestDto)))
                .andExpect(status().isBadRequest());
    }
}
