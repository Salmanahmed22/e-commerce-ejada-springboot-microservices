package org.codewithsoly.shopservice.controller;

import org.codewithsoly.shopservice.Dto.UserDto;
import org.codewithsoly.shopservice.model.User;
import org.codewithsoly.shopservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        if (userService.existsByEmail(userDto.getEmail())) {
            return new ResponseEntity<>("email is already taken",HttpStatus.BAD_REQUEST);
        }
        Map<String, Object> response = userService.registerUser(userDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Map<String, Object> response = userService.loginUser(user);
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
