package com.ead.authuser.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UserDto implements Serializable {
    String username;
    String email;
    String password;
    String fullName;
    String phoneNumber;
    String cpf;
    String imageUrl;
}
