package org.teamone.user.command.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.user.command.Application.service.UserAuthService;
import org.teamone.user.command.domain.dto.UserDTO;
import org.teamone.user.command.domain.aggregate.entity.UserEntity;
import org.teamone.user.command.domain.repository.UserRepository;
import org.teamone.user.command.domain.aggregate.types.AccessLevel;
import org.teamone.user.command.domain.aggregate.types.Password;
import org.teamone.user.command.domain.aggregate.types.Provider;
import org.teamone.user.command.domain.aggregate.types.UserStatus;

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
                .password(new Password(newUser.getPassword()))
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
}
