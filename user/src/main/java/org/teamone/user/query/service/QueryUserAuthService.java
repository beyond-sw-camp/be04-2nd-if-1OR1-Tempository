package org.teamone.user.query.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.teamone.user.query.dto.QueryUserDTO;

public interface QueryUserAuthService extends UserDetailsService {
    QueryUserDTO getUserDetailsByEmail(String userEmail);
}
