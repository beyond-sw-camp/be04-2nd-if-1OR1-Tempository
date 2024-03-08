package org.teamone.user.command.Application.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.teamone.user.command.domain.dto.CommandUserDTO;

public interface CommandUserAuthService extends UserDetailsService {

    CommandUserDTO signUp(CommandUserDTO newUser);
}
