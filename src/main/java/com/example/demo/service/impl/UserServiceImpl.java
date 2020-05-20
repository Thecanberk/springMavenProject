package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.user.User;
import com.example.demo.repository.user.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.ExecutionException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO getUser(String userName) {
        UserDTO responseDTO = new UserDTO();
        try{
            User response = userRepository.findByUserName(userName);
            if(response ==  null){
                responseDTO.setId(-1L);
            }
            return response.toDTO();
        } catch (Exception e){
            responseDTO.setId(-1L);
            return responseDTO;
        }
    }

    @Override
    public UserDTO createUser(UserDTO request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setPassWord(request.getPassWord());
        User savedEntity = userRepository.save(user);
        return savedEntity.toDTO();
    }

    @Override
    public UserDTO updateUserPassWord(UserDTO request) {
        User user = userRepository.findByUserName(request.getUserName());
        user.setPassWord(request.getPassWord());
        User updatedUser = userRepository.save(user);
        return updatedUser.toDTO();
    }
}
