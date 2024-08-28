package com.dl_users.dto;


import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String id;

    private String name;

    private String email;

    private String password;

    private List<PhoneDto> phones;

    private String created;

    private String modified;

    private String lastLogin;

    private String token;

    private boolean isActive;


}