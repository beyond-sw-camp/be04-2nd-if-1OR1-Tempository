package org.teamone.user.command.Application.service;

import org.apache.http.auth.InvalidCredentialsException;
import org.teamone.user.command.domain.dto.CommandUserDTO;

public interface CommandUserAuthService {

    CommandUserDTO signUp(CommandUserDTO newUser);

    CommandUserDTO modifyUserInfo(CommandUserDTO updatedUserInfo, String token);

    String modifyPassword(String oldPassword, String newPassword, String token) throws InvalidCredentialsException;
}
