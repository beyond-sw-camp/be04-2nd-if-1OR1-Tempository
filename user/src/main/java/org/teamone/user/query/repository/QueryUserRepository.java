package org.teamone.user.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamone.user.query.domainData.entity.QueryUserEntity;

@Repository
public interface QueryUserRepository extends JpaRepository<QueryUserEntity, Integer> {
    QueryUserEntity findByEmail(String email);

    QueryUserEntity findByUserId(String userId);
}
