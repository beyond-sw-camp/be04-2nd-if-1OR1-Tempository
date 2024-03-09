package org.teamone.user.query.service;

import org.teamone.user.query.dto.QueryUserDTO;

public interface QueryUserService {

    QueryUserDTO getUserDetailsById(String id);

    QueryUserDTO getUserDetailsByEmail(String email);

    QueryUserDTO getUserByToken(String token);
}
