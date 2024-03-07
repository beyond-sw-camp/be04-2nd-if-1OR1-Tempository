package org.teamone.user.query.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teamone.user.query.domainData.vo.ResponseProjectMemberVO;
import org.teamone.user.query.dto.QueryUserDTO;
import org.teamone.user.query.service.QueryProjectMemberService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("project")
public class QueryProjectMemberController {

    private QueryProjectMemberService queryProjectMemberService;

    @Autowired
    public QueryProjectMemberController(QueryProjectMemberService queryProjectMemberService) {
        this.queryProjectMemberService = queryProjectMemberService;
    }

    /* 설명. 프로젝트 참여중인 회원들 반환 */
    @GetMapping("/join-members/{projectId}")
    public ResponseEntity<List<ResponseProjectMemberVO>> projectJoinMembers(@PathVariable("projectId") String id) {
        List<QueryUserDTO> userDTOs = queryProjectMemberService.getProjectMembers(id);

        List<ResponseProjectMemberVO> response = userDTOs.stream()
                .map(userDTO -> ResponseProjectMemberVO.builder()
                        .name(userDTO.getName())
                        .nickname(userDTO.getNickname())
                        .userId(userDTO.getUserId())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
