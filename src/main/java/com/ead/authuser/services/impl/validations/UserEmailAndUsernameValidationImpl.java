package com.ead.authuser.services.impl.validations;

import com.ead.authuser.models.UserModel;
import com.ead.authuser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.openmbean.KeyAlreadyExistsException;

@Component
public class UserEmailAndUsernameValidationImpl implements Validations<UserModel> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void validate(UserModel userModel) throws KeyAlreadyExistsException {
        if (userRepository.existsByUsername(userModel.getUsername())) {
            throw new KeyAlreadyExistsException("Username already registered");
        }
        if (userRepository.existsByEmail(userModel.getEmail())) {
            throw new KeyAlreadyExistsException("Email already registered");
        }
    }
}
