package com.rebalcomb.model.dto.auth;

import lombok.Data;

@Data
public class SignUpRequestDto {

    private String username;
    private String email;
    private String fullName;
    private String password;

}
