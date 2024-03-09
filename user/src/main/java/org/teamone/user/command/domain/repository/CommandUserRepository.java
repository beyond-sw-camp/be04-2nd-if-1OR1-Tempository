package org.teamone.user.command.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamone.user.command.domain.aggregate.entity.CommandUserEntity;

@Repository
public interface CommandUserRepository extends JpaRepository<CommandUserEntity, Integer> {

    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);

    CommandUserEntity findByUserId(String userId);
}
