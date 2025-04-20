package com.nguyennhutduy.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nguyennhutduy.demo.entity.User;
import com.nguyennhutduy.demo.repository.UserRepository;
import com.nguyennhutduy.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(
                userId)
                .orElseThrow(() -> new RuntimeException("User with ID " + userId + " not found"));
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getName() != null && !user.getName().equals(existingUser.getName())) {
            existingUser.setName(user.getName());
        }
        if (user.getAddress() != null && !user.getAddress().equals(existingUser.getAddress())) {
            existingUser.setAddress(user.getAddress());
        }
        if (user.getEmail() != null && !user.getEmail().equals(existingUser.getEmail())) {
            existingUser.setAddress(user.getEmail());
        }
        if (user.getUsername() != null && !user.getUsername().equals(existingUser.getUsername())) {
            existingUser.setUsername(user.getUsername());
        }
        if (user.getPassword() != null && !user.getPassword().equals(existingUser.getPassword())) {
            existingUser.setPassword(user.getPassword());
        }
        if (user.getStatus() != 0 && user.getStatus() != existingUser.getStatus()) {
            existingUser.setStatus(user.getStatus());
        }
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User with ID " + userId + " not found");
        }
        userRepository.deleteById(userId);
    }

}
