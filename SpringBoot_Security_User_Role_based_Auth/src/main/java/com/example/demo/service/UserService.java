package com.example.demo.service;

import com.example.demo.dtos.UserDTO;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    void updateUserRoles(Long userId, String roleName);
    List<User> getAllUsers();
    UserDTO getUserById(Long userId);

}
