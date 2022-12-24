package com.rebalcomb.api.auth;

import com.rebalcomb.exceptions.UsernameAlreadyExistException;
import com.rebalcomb.exceptions.authentication.BadCredentialsException;
import com.rebalcomb.mapper.UserMapper;
import com.rebalcomb.model.dto.auth.LoginRequestDto;
import com.rebalcomb.model.dto.auth.SignUpRequestDto;
import com.rebalcomb.model.entity.User;
import com.rebalcomb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            User user = UserMapper.INSTANCE.toUser(loginRequestDto);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            String token = userService.login(user);
            Map<Object, Object> response = new HashMap<>();
            response.put("username", user.getUsername());
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException(e.getMessage());
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignUpRequestDto signUpRequestDto) {
        try {
            User user = UserMapper.INSTANCE.toUser(signUpRequestDto);

            String token = userService.signUp(user);

            Map<Object, Object> response = new HashMap<>();
            response.put("username", user.getUsername());
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (UsernameAlreadyExistException e) {
            throw new UsernameAlreadyExistException(e.getMessage());
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }


}
