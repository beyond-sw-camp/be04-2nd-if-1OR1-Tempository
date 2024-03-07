package org.teamone.user.query.service;

import org.teamone.user.query.dto.QueryUserDTO;

public interface QueryUserService {

    QueryUserDTO getUserById(String id);

    QueryUserDTO getUserByEmail(String email);
}
