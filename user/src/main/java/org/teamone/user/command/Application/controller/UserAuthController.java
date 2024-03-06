package org.teamone.user.command.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teamone.user.command.Application.service.UserAuthService;
import org.teamone.user.command.domain.aggregate.vo.RequestUserAuthVO;
import org.teamone.user.command.domain.aggregate.vo.ResponseUserAuthVO;
import org.teamone.user.command.domain.dto.UserDTO;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    private UserAuthService userAuthService;

    @Autowired
    public UserAuthController(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    /* 설명. 회원가입 */
    @PostMapping("/signup")
    public ResponseEntity<ResponseUserAuthVO> signUpUser(@RequestBody RequestUserAuthVO user) {
        UserDTO userDTO = UserDTO.builder()
                .name(user.getName())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        UserDTO resultUserDTO = userAuthService.signUp(userDTO);

        ResponseUserAuthVO responseUser = ResponseUserAuthVO.builder()
                .userId(resultUserDTO.getUserId())
                .email(resultUserDTO.getEmail())
                .nickname(resultUserDTO.getNickname())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }
}
