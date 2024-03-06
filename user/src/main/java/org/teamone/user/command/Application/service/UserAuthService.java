package org.teamone.user.command.Application.service;

import org.teamone.user.command.domain.dto.UserDTO;

public interface UserAuthService {

    UserDTO signUp(UserDTO newUser);
}
