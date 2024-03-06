package org.teamone.user.command.Application.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.teamone.user.command.domain.dto.UserDTO;

public interface UserAuthService extends UserDetailsService {

    UserDTO signUp(UserDTO newUser);
}
