package org.teamone.user.command.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teamone.user.command.Application.service.CommandUserAuthService;
import org.teamone.user.command.domain.aggregate.vo.RequestUserAuthVO;
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
}
