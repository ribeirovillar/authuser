package com.ead.authuser.services;

import com.ead.authuser.models.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    Optional<UserModel> getUserById(UUID userId);

    Optional<List<UserModel>> getAllUsers();

    Optional<UserModel> createUser(UserModel userModel) throws Exception;

    Optional<UserModel> updateUser(UserModel userModel);

    void deleteUser(UUID userId);

    Boolean existUserById(UUID userId);

    boolean existByEmail(String email);

    boolean existByUsername(String username);


}
