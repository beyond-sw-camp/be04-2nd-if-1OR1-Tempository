package org.teamone.user.command.Application.service;

import org.teamone.user.command.domain.dto.CommandUserDTO;

public interface CommandUserAuthService {

    CommandUserDTO signUp(CommandUserDTO newUser);
}
