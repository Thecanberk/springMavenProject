package com.example.demo.service;

import com.example.demo.dto.UserDTO;

public interface UserService {

    UserDTO getUser(String userName);
    UserDTO createUser(UserDTO request);
    UserDTO updateUserPassWord(UserDTO request);
}
