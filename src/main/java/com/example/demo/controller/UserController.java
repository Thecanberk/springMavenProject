package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.user.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping("/{username}")
    public UserDTO getUserByUserName(@PathVariable("username") String userName) {
        return userService.getUser(userName);
    }

    @PostMapping("/createuser")
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @PutMapping("/updatepassword")
    public UserDTO updateUserPassWord(@RequestBody UserDTO userDTO){
        return userService.updateUserPassWord(userDTO);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<String> getProducts() {
        List<String> productsList = new ArrayList<>();
        productsList.add("Honey");
        productsList.add("Almond");
        return productsList;
    }
}

