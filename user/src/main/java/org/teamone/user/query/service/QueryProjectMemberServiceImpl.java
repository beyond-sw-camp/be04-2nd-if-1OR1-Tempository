package org.teamone.user.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.user.query.domainData.entity.QueryProjectMemberEntity;
import org.teamone.user.query.domainData.entity.QueryUserEntity;
import org.teamone.user.query.dto.QueryUserDTO;
import org.teamone.user.query.repository.ProjectMemberMapper;
import org.teamone.user.query.repository.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueryProjectMemberServiceImpl implements QueryProjectMemberService{

    private ProjectMemberMapper projectMemberMapper;
    private UserMapper userMapper;

    @Autowired
    public QueryProjectMemberServiceImpl(ProjectMemberMapper projectMemberMapper,
                                         UserMapper userMapper) {
        this.projectMemberMapper = projectMemberMapper;
        this.userMapper = userMapper;
    }

    /* 설명. 프로젝트에 참가한 회원들을 반환하는 메소드 */
    @Override
    public List<QueryUserDTO> getProjectMembers(String projectId) {

        int id = Integer.valueOf(projectId);

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
}
