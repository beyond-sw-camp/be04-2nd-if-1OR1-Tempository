package org.teamone.user.command.Application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.user.command.domain.dto.CommandUserDTO;
import org.teamone.user.command.domain.aggregate.entity.CommandUserEntity;
import org.teamone.user.command.domain.repository.CommandUserRepository;
import org.teamone.user.command.domain.aggregate.enums.AccessLevel;
import org.teamone.user.command.domain.aggregate.enums.Provider;
import org.teamone.user.command.domain.aggregate.enums.UserStatus;

import java.util.UUID;

@Service
public class CommandUserAuthServiceImpl implements CommandUserAuthService {

    private final CommandUserRepository commandUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public CommandUserAuthServiceImpl(CommandUserRepository commandUserRepository,
                                      BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.commandUserRepository = commandUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public CommandUserDTO signUp(CommandUserDTO newUser) {
        if (commandUserRepository.existsByEmail(newUser.getEmail())) {
            throw new DuplicateKeyException("이미 사용 중인 이메일입니다.");
        }
        if (commandUserRepository.existsByNickname(newUser.getNickname())) {
            throw new DuplicateKeyException("이미 사용 중인 닉네임입니다.");
        }

        CommandUserEntity commandUserEntity = CommandUserEntity.builder()
                .name(newUser.getName())
                .nickname(newUser.getNickname())
                .provider(Provider.LOCAL)
                .accessLevel(AccessLevel.NORMAL)
                .userStatus(UserStatus.ACTIVE)
                .grade(1)
                .email(newUser.getEmail())
                .password(bCryptPasswordEncoder.encode(newUser.getPassword()))
                .userId((UUID.randomUUID().toString()))
                .build();

        CommandUserEntity user = commandUserRepository.save(commandUserEntity);

        return CommandUserDTO.builder()
                .nickname(user.getNickname())
                .email(user.getEmail())
                .userId(user.getUserId())
                .build();
    }
}
