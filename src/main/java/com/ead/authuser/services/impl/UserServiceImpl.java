package com.ead.authuser.services.impl;

import com.ead.authuser.enums.UserStatus;
import com.ead.authuser.enums.UserType;
import com.ead.authuser.models.UserModel;
import com.ead.authuser.repositories.UserRepository;
import com.ead.authuser.services.UserService;
import com.ead.authuser.services.impl.validations.Validations;
import lombok.AllArgsConstructor;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final List<Validations<UserModel>> validations;

    @Override
    public Optional<UserModel> getUserById(UUID userId) {
        return Optional.of(userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException(String.format("User not found with id: %s", userId))));
    }

    @Override
    public Optional<List<UserModel>> getAllUsers() {
        return Optional.of(userRepository.findAll());
    }

    @Override
    public Optional<UserModel> createUser(UserModel userModel) throws Exception {
        for (Validations<UserModel> userValidation : validations) {
            userValidation.validate(userModel);
        }
        userModel.setUserStatus(UserStatus.ACTIVE);
        userModel.setUserType(UserType.STUDENT);
        userModel.setCreationDate(LocalDateTime.now());
        userModel.setLastUpdateDate(LocalDateTime.now());
        return Optional.of(userRepository.save(userModel));
    }

    @Override
    public Optional<UserModel> updateUser(UserModel userModel) {
        var response = this.getUserById(userModel.getUserId());
        userModel.setPassword(response.get().getPassword());
        userModel.setCreationDate(response.get().getCreationDate());
        userModel.setLastUpdateDate(LocalDateTime.now());
        return Optional.of(userRepository.save(userModel));
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepository.delete(this.getUserById(userId).get());
    }

    @Override
    public Boolean existUserById(UUID userId) {
        return userRepository.existsById(userId);
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
