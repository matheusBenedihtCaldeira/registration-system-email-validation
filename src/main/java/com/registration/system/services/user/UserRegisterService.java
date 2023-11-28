package com.registration.system.services.user;

import com.registration.system.models.dto.UserDTO;
import com.registration.system.models.entities.User;
import com.registration.system.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService {

    @Autowired
    private UserRepository repository;

    public User register(UserDTO data){
        User user = convertDTO(data);
        user.setPassword(encryptPassword(user.getPassword()));
        return repository.save(user);
    }

    public User convertDTO(UserDTO dto){
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }

    public String encryptPassword(String password){
        String encryptedPassword = new BCryptPasswordEncoder().encode(password);
        return encryptedPassword;
    }
}