package org.teamone.user.command.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.user.command.domain.dto.UserDTO;
import org.teamone.user.command.domain.entity.User;
import org.teamone.user.command.domain.repository.UserRepository;
import org.teamone.user.command.domain.types.AccessLevel;
import org.teamone.user.command.domain.types.Password;
import org.teamone.user.command.domain.types.Provider;
import org.teamone.user.command.domain.types.UserStatus;

@Service
public class UserAuthService {

    private final UserRepository userRepository;

    @Autowired
    public UserAuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void signUp(UserDTO newUser) {
        if (userRepository.existsByEmail(newUser.getEmail())) {
            throw new DuplicateKeyException("이미 사용 중인 이메일입니다.");
        }
        if (userRepository.existsByNickname(newUser.getNickname())) {
            throw new DuplicateKeyException("이미 사용 중인 닉네임입니다.");
        }

        User user = User.builder()
                .name(newUser.getName())
                .nickname(newUser.getNickname())
                .provider(Provider.LOCAL)
                .accessLevel(AccessLevel.NORMAL)
                .userStatus(UserStatus.ACTIVE)
                .grade(1)
                .email(newUser.getEmail())
                .password(new Password(newUser.getPassword()))
                .build();

        userRepository.save(user);
    }
}
