package com.example.service.impl;


import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUserByEmail(String email, User updatedUser) {
        Optional<User> existingUserOpt = userRepository.findByEmail(email);

        if (existingUserOpt.isEmpty()) {
            return null; // Or throw exception
        }

        User existingUser = existingUserOpt.get();

        existingUser.setFullName(updatedUser.getFullName());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        existingUser.setAge(updatedUser.getAge());
        existingUser.setSex(updatedUser.getSex());
        existingUser.setBloodGroup(updatedUser.getBloodGroup());
        existingUser.setStatus(updatedUser.getStatus());
        existingUser.setFullAddress(updatedUser.getFullAddress());

        return userRepository.save(existingUser);
    }
}
