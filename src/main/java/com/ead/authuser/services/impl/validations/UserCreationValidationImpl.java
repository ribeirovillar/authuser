package com.ead.authuser.services.impl.validations;

import com.ead.authuser.models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingRequestValueException;

import java.util.Objects;

@Component
public class UserCreationValidationImpl implements Validations<UserModel> {
    @Override
    public void validate(UserModel userModel) throws MissingRequestValueException {
        if (Objects.isNull(userModel.getUsername())) {
            throw new MissingRequestValueException("Username is a mandatory field");
        }
        if (Objects.isNull(userModel.getEmail())) {
            throw new MissingRequestValueException("Email is a mandatory field");
        }
        if (Objects.isNull(userModel.getPassword())) {
            throw new MissingRequestValueException("Password is a mandatory field");
        }
    }
}
