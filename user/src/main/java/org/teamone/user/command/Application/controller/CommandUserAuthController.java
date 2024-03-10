package org.teamone.user.command.Application.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teamone.user.command.Application.service.CommandUserAuthService;
import org.teamone.user.command.domain.aggregate.vo.RequestUpdatePasswordVO;
import org.teamone.user.command.domain.aggregate.vo.RequestUserAuthVO;
import org.teamone.user.command.domain.aggregate.vo.ResponseUpdatePasswordVO;
import org.teamone.user.command.domain.aggregate.vo.ResponseUserAuthVO;
import org.teamone.user.command.domain.dto.CommandUserDTO;

@RestController
@RequestMapping("/auth")
public class CommandUserAuthController {

    private final CommandUserAuthService commandUserAuthService;

    @Autowired
    public CommandUserAuthController(CommandUserAuthService commandUserAuthService) {
        this.commandUserAuthService = commandUserAuthService;
    }

    /* 설명. 회원가입 */
    @PostMapping("/signup")
    public ResponseEntity<ResponseUserAuthVO> signUpUser(@RequestBody RequestUserAuthVO user) {
        CommandUserDTO commandUserDTO = CommandUserDTO.builder()
                .name(user.getName())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        CommandUserDTO resultCommandUserDTO = commandUserAuthService.signUp(commandUserDTO);

        ResponseUserAuthVO responseUser = ResponseUserAuthVO.builder()
                .email(resultCommandUserDTO.getEmail())
                .nickname(resultCommandUserDTO.getNickname())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @PostMapping("/updateInfo")
    public ResponseEntity<ResponseUserAuthVO> updateUserInfo(@RequestBody RequestUserAuthVO user, HttpServletRequest request) {

        CommandUserDTO commandUserDTO = CommandUserDTO.builder()
                .name(user.getName())
                .nickname(user.getNickname())
                .build();

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        try {
            CommandUserDTO resultCommandUserDTO = commandUserAuthService.modifyUserInfo(commandUserDTO, token);

            ResponseUserAuthVO response = ResponseUserAuthVO.builder()
                    .name(resultCommandUserDTO.getName())
                    .nickname(resultCommandUserDTO.getNickname())
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (DuplicateKeyException e) {
            ResponseUserAuthVO response = ResponseUserAuthVO.builder()
                    .message(e.getMessage())
                    .build();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PostMapping("/updatePassword")
    public ResponseEntity<ResponseUpdatePasswordVO> updatePassword(@RequestBody RequestUpdatePasswordVO user, HttpServletRequest request) {

        try {
            String oldPassword = user.getOldPassword();
            String newPassword = user.getNewPassword();
            String token = request.getHeader(HttpHeaders.AUTHORIZATION);

            String result = commandUserAuthService.modifyPassword(oldPassword, newPassword, token);

            ResponseUpdatePasswordVO response = ResponseUpdatePasswordVO.builder()
                    .message(result)
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            ResponseUpdatePasswordVO response = ResponseUpdatePasswordVO.builder()
                    .message(e.getMessage())
                    .build();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
