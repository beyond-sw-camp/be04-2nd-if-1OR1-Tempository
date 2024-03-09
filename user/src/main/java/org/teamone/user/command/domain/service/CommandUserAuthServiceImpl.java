package org.teamone.user.command.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.user.command.Application.service.CommandUserAuthService;
import org.teamone.user.command.domain.dto.CommandUserDTO;
import org.teamone.user.command.domain.aggregate.entity.CommandUserEntity;
import org.teamone.user.command.domain.repository.CommandUserRepository;
import org.teamone.user.command.domain.aggregate.enums.AccessLevel;
import org.teamone.user.command.domain.aggregate.enums.Provider;
import org.teamone.user.command.domain.aggregate.enums.UserStatus;
import org.teamone.user.common.security.auth.JwtUserResolver;

import java.util.UUID;

@Service
public class CommandUserAuthServiceImpl implements CommandUserAuthService {

    private final CommandUserRepository commandUserRepository;
    private final JwtUserResolver jwtUserResolver;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public CommandUserAuthServiceImpl(CommandUserRepository commandUserRepository, JwtUserResolver jwtUserResolver,
                                      BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.commandUserRepository = commandUserRepository;
        this.jwtUserResolver = jwtUserResolver;
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

        CommandUserDTO commandUserDTO = CommandUserDTO.builder()
                .nickname(user.getNickname())
                .email(user.getEmail())
                .userId(user.getUserId())
                .build();

        return commandUserDTO;
    }

    @Override
    @Transactional
    public CommandUserDTO modifyUserInfo(CommandUserDTO updatedUserInfo, String token) {

        String userId = jwtUserResolver.resolveUserFromTokenForUser(token);

        CommandUserEntity user = commandUserRepository.findByUserId(userId);

        if (updatedUserInfo.getName() != null) {
            user.setName(updatedUserInfo.getName());
        }

        if (updatedUserInfo.getNickname() != null) {

            if (commandUserRepository.existsByNickname(updatedUserInfo.getNickname())) {

                throw new DuplicateKeyException("이미 사용 중인 닉네임입니다.");
            }
            user.setNickname(updatedUserInfo.getNickname());
        }

        commandUserRepository.save(user);

        CommandUserDTO result = CommandUserDTO.builder()
                .name(user.getName())
                .nickname(user.getNickname())
                .build();

        return result;
    }
}
