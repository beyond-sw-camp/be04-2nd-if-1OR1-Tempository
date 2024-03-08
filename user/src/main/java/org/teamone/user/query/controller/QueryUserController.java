package org.teamone.user.query.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teamone.user.query.domainData.vo.ResponseUserForPublicVO;
import org.teamone.user.query.domainData.vo.ResponseUserForServiceVO;
import org.teamone.user.query.dto.QueryUserDTO;
import org.teamone.user.query.service.QueryUserService;

@RestController
@RequestMapping
public class QueryUserController {

    private final QueryUserService queryUserService;

    @Autowired
    public QueryUserController(QueryUserService queryUserService) {
        this.queryUserService = queryUserService;
    }

    /* 설명. id 로 유저 정보 반환 */
    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseUserForServiceVO> getUserById(@PathVariable("id") String id) {

        /* 필기. 이후에 유저는 접근 못하는 validation 추가할 것 */

        try {
            QueryUserDTO userDTO = queryUserService.getUserDetailsById(id);

            ResponseUserForServiceVO response = ResponseUserForServiceVO.builder()
                    .name(userDTO.getName())
                    .nickname(userDTO.getNickname())
                    .followerCnt(userDTO.getFollowerCnt())
                    .followingCnt(userDTO.getFollowingCnt())
                    .grade(userDTO.getGrade())
                    .email(userDTO.getEmail())
                    .userId(userDTO.getUserId())
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) { // 예를 들어, 사용자를 찾지 못한 경우의 예외
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseUserForServiceVO.builder().message("해당 유저를 찾을 수 없습니다").build());
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseUserForPublicVO> getUserByEmail(@PathVariable("email") String email) {
        try {
            QueryUserDTO userDTO = queryUserService.getUserDetailsByEmail(email);

            ResponseUserForPublicVO response = ResponseUserForPublicVO.builder()
                    .name(userDTO.getName())
                    .nickname(userDTO.getNickname())
                    .followerCnt(userDTO.getFollowerCnt())
                    .followingCnt(userDTO.getFollowingCnt())
                    .grade(userDTO.getGrade())
                    .email(userDTO.getEmail())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseUserForPublicVO.builder().message("해당 유저를 찾을 수 없습니다").build());
        }
    }
}
