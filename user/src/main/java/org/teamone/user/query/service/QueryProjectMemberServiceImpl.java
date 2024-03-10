package org.teamone.user.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.user.client.ProjectServiceClient;
import org.teamone.user.common.security.auth.JwtUserResolver;
import org.teamone.user.query.domainData.entity.QueryProjectMemberEntity;
import org.teamone.user.query.domainData.entity.QueryUserEntity;
import org.teamone.user.query.domainData.vo.ResponseProjectVO;
import org.teamone.user.query.dto.QueryProjectDTO;
import org.teamone.user.query.dto.QueryUserDTO;
import org.teamone.user.query.repository.ProjectMemberMapper;
import org.teamone.user.query.repository.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueryProjectMemberServiceImpl implements QueryProjectMemberService {

    private final ProjectMemberMapper projectMemberMapper;
    private final ProjectServiceClient projectServiceClient;
    private final UserMapper userMapper;
    private final JwtUserResolver jwtUserResolver;

    @Autowired
    public QueryProjectMemberServiceImpl(ProjectMemberMapper projectMemberMapper, ProjectServiceClient projectServiceClient,
                                         UserMapper userMapper, JwtUserResolver jwtUserResolver) {
        this.projectMemberMapper = projectMemberMapper;
        this.projectServiceClient = projectServiceClient;
        this.userMapper = userMapper;
        this.jwtUserResolver = jwtUserResolver;
    }

    /* 설명. 프로젝트에 참가한 회원들을 반환하는 메소드 */
    @Override
    public List<QueryUserDTO> getProjectMembersDetailsByProjectId(String projectId) {

        int id = Integer.parseInt(projectId);

        List<QueryProjectMemberEntity> projectMemberEntities = projectMemberMapper.findProjectMembers(id);

        List<QueryUserDTO> userDTOs = projectMemberEntities.stream()
                .map(projectMember -> {
                    QueryUserEntity user = userMapper.findUserById(projectMember.getMemberId());
                    return QueryUserDTO.builder()
                            .name(user.getName())
                            .nickname(user.getNickname())
                            .userId(user.getUserId())
                            .build();
                })
                .collect(Collectors.toList());

        return userDTOs;
    }

    @Override
    public List<QueryProjectDTO> getMyProjects(String token) {
        System.out.println("token = " + token);
        String userId = jwtUserResolver.resolveUserFromTokenForUser(token);

        QueryUserEntity user = userMapper.findUserByUserId(userId);

        System.out.println("id String 으로 잘 됨?: " + String.valueOf(user.getId()));
        List<ResponseProjectVO> projectList = projectServiceClient.getUserProjects(String.valueOf(user.getId()), token);

        List<QueryProjectDTO> result = projectList.stream()
                .map(project -> QueryProjectDTO.builder()
                        .projectId(project.getId())
                        .status(project.getStatus())
                        .name(project.getName())
                        .build())
                .collect(Collectors.toList());

        return result;
    }
}
