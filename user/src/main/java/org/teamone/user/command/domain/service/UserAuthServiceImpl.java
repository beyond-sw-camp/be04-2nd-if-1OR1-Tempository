package org.teamone.user.command.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.user.command.Application.service.UserAuthService;
import org.teamone.user.command.domain.dto.UserDTO;
import org.teamone.user.command.domain.aggregate.entity.UserEntity;
import org.teamone.user.command.domain.repository.UserRepository;
import org.teamone.user.command.domain.aggregate.enums.AccessLevel;
import org.teamone.user.command.domain.aggregate.enums.Provider;
import org.teamone.user.command.domain.aggregate.enums.UserStatus;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    private final UserRepository userRepository;

    @Autowired
    public UserAuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDTO signUp(UserDTO newUser) {
        if (userRepository.existsByEmail(newUser.getEmail())) {
            throw new DuplicateKeyException("이미 사용 중인 이메일입니다.");
        }
        if (userRepository.existsByNickname(newUser.getNickname())) {
            throw new DuplicateKeyException("이미 사용 중인 닉네임입니다.");
        }

        UserEntity userEntity = UserEntity.builder()
                .name(newUser.getName())
                .nickname(newUser.getNickname())
                .provider(Provider.LOCAL)
                .accessLevel(AccessLevel.NORMAL)
                .userStatus(UserStatus.ACTIVE)
                .grade(1)
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .userId((UUID.randomUUID().toString()))
                .build();

        UserEntity user = userRepository.save(userEntity);

        UserDTO userDTO = UserDTO.builder()
                .nickname(user.getNickname())
                .email(user.getEmail())
                .userId(user.getUserId())
                .build();

        return userDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null) {
            throw new UsernameNotFoundException(email + "아이디의 유저는 존재하지 않습니다.");
        }

        return new User(userEntity.getEmail(), userEntity.getPassword(),
                true, true, true, true,
                new ArrayList<>());
    }
}
