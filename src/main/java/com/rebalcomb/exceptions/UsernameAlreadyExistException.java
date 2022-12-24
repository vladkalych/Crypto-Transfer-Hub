package com.rebalcomb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UsernameAlreadyExistException extends AuthenticationException {

    public UsernameAlreadyExistException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UsernameAlreadyExistException(String msg) {
        super(msg);
    }
}
