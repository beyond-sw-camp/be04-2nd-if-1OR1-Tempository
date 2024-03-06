package org.teamone.user.command.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamone.user.command.domain.aggregate.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);

    UserEntity findByEmail(String email);
}
