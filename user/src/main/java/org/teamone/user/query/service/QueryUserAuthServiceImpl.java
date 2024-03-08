package org.teamone.user.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.teamone.user.query.domainData.entity.QueryUserEntity;
import org.teamone.user.query.dto.QueryUserDTO;
import org.teamone.user.query.repository.QueryUserRepository;

import java.util.ArrayList;

@Service
public class QueryUserAuthServiceImpl implements QueryUserAuthService {

    private final QueryUserRepository queryUserRepository;

    @Autowired
    public QueryUserAuthServiceImpl(QueryUserRepository queryUserRepository) {
        this.queryUserRepository = queryUserRepository;
    }

    @Override
    public QueryUserDTO getUserDetailsByEmail(String email) {
        QueryUserEntity userEntity = queryUserRepository.findByEmail(email);

        if (userEntity == null) {
            throw new UsernameNotFoundException(email + "아이디의 유저는 존재하지 않습니다.");
        }

        QueryUserDTO userDTO = QueryUserDTO.builder()
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


        return userDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        QueryUserEntity queryUserEntity = queryUserRepository.findByEmail(email);

        if (queryUserEntity == null) {
            throw new UsernameNotFoundException(email + " 유저는 존재하지 않습니다.");
        }

        return new User(queryUserEntity.getEmail(), queryUserEntity.getPassword(),
                true, true, true, true,
                new ArrayList<>());
    }
}
