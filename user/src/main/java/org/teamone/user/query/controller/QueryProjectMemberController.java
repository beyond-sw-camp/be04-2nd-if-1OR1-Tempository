package org.teamone.user.query.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teamone.user.query.domainData.vo.ResponseProjectMemberVO;
import org.teamone.user.query.domainData.vo.ResponseProjectVO;
import org.teamone.user.query.dto.QueryProjectDTO;
import org.teamone.user.query.dto.QueryUserDTO;
import org.teamone.user.query.service.QueryProjectMemberService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("project")
public class QueryProjectMemberController {

    private final QueryProjectMemberService queryProjectMemberService;

    @Autowired
    public QueryProjectMemberController(QueryProjectMemberService queryProjectMemberService) {
        this.queryProjectMemberService = queryProjectMemberService;
    }

    /* 설명. 프로젝트 참여중인 회원들 반환 */
    @GetMapping("/join-members/{projectId}")
    public ResponseEntity<List<ResponseProjectMemberVO>> projectJoinMembers(@PathVariable("projectId") String id) {
        List<QueryUserDTO> userDTOs = queryProjectMemberService.getProjectMembersDetailsByProjectId(id);

        List<ResponseProjectMemberVO> response = userDTOs.stream()
                .map(userDTO -> ResponseProjectMemberVO.builder()
                        .name(userDTO.getName())
                        .nickname(userDTO.getNickname())
                        .userId(userDTO.getUserId())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /* 설명. 현재 유저가 참여 중인 프로젝트 리스트 */
    @GetMapping("/my-project")
    public ResponseEntity<List<ResponseProjectVO>> getMyProjects(HttpServletRequest request) {

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        List<QueryProjectDTO> result = queryProjectMemberService.getMyProjects(token);

        List<ResponseProjectVO> response = result.stream()
                .map(projectDTO -> ResponseProjectVO.builder()
                        .id(projectDTO.getProjectId())
                        .status(projectDTO.getStatus())
                        .name(projectDTO.getName())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
