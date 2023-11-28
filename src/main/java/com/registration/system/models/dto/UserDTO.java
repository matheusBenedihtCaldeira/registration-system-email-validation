package com.registration.system.models.dto;

import com.registration.system.models.enums.Role;

public record UserDTO(Long id, String name, String username,String email, String password, Role role) {
}
