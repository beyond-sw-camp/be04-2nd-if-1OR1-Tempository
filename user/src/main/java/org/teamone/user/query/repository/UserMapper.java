package org.teamone.user.query.repository;

import org.apache.ibatis.annotations.Mapper;
import org.teamone.user.query.domainData.entity.QueryUserEntity;


@Mapper
public interface UserMapper {
    QueryUserEntity findUserById(int id);

    QueryUserEntity findUserByEmail(String email);

    QueryUserEntity findUserByUserId(String userId);
}
