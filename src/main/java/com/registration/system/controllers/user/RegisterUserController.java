package com.registration.system.controllers.user;

import com.registration.system.models.dto.UserDTO;
import com.registration.system.models.entities.User;
import com.registration.system.services.user.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/register")
public class RegisterUserController {

    @Autowired
    private UserRegisterService service;

    @PostMapping
    public ResponseEntity<User> register(@RequestBody UserDTO data){
        User user = service.register(data);
        return ResponseEntity.ok().body(user);
    }
}