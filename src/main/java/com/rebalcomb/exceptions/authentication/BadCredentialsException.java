package com.rebalcomb.exceptions.authentication;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class BadCredentialsException extends AuthenticationException {
    public BadCredentialsException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BadCredentialsException(String msg) {
        super(msg);
    }
}
