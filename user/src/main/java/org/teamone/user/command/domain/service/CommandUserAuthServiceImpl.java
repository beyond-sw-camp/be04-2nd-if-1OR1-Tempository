package org.teamone.user.command.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

import java.util.ArrayList;
import java.util.UUID;

@Service
public class CommandUserAuthServiceImpl implements CommandUserAuthService {

    private final CommandUserRepository commandUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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

        CommandUserDTO commandUserDTO = CommandUserDTO.builder()
                .nickname(user.getNickname())
                .email(user.getEmail())
                .userId(user.getUserId())
                .build();

        return commandUserDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        CommandUserEntity commandUserEntity = commandUserRepository.findByEmail(email);

        if (commandUserEntity == null) {
            throw new UsernameNotFoundException(email + " 유저는 존재하지 않습니다.");
        }

        return new User(commandUserEntity.getEmail(), commandUserEntity.getPassword(),
                true, true, true, true,
                new ArrayList<>());
    }
}
