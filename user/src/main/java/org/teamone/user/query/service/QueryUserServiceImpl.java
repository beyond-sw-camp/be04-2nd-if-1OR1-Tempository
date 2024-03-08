package org.teamone.user.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.user.query.domainData.entity.QueryUserEntity;
import org.teamone.user.query.dto.QueryUserDTO;
import org.teamone.user.query.repository.UserMapper;

@Service
public class QueryUserServiceImpl implements QueryUserService {

    private final UserMapper userMapper;

    @Autowired
    public QueryUserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public QueryUserDTO getUserDetailsById(String input) {
        int id = Integer.parseInt(input);

        QueryUserEntity userEntity = userMapper.findUserById(id);

        return QueryUserDTO.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .nickname(userEntity.getNickname())
                .userStatus(userEntity.getUserStatus())
                .followerCnt(userEntity.getFollowerCnt())
                .followingCnt(userEntity.getFollowingCnt())
                .grade(userEntity.getGrade())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .snsId(userEntity.getSnsId())
                .userId(userEntity.getUserId())
                .build();
    }

    @Override
    public QueryUserDTO getUserDetailsByEmail(String email) {
        QueryUserEntity userEntity = userMapper.findUserByEmail(email);

        return QueryUserDTO.builder()
                .name(userEntity.getName())
                .nickname(userEntity.getNickname())
                .followerCnt(userEntity.getFollowerCnt())
                .followingCnt(userEntity.getFollowingCnt())
                .grade(userEntity.getGrade())
                .email(userEntity.getEmail())
                .build();
    }
}
