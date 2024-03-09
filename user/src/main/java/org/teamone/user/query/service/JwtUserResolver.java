package org.teamone.user.query.service;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.teamone.user.query.domainData.entity.QueryUserEntity;
import org.teamone.user.query.repository.UserMapper;

@Component
public class JwtUserResolver {

    private final UserMapper userMapper;
    private final QueryUserAuthService queryUserAuthService;
    private final Environment environment;

    @Autowired
    public JwtUserResolver(UserMapper userMapper, QueryUserAuthService queryUserAuthService, Environment environment) {
        this.userMapper = userMapper;
        this.queryUserAuthService = queryUserAuthService;
        this.environment = environment;
    }

    protected String resolveUserFromToken(String token) {
        String userId = null;

        try {
            if (token != null) {
                // 토큰을 검증하고 페이로드에서 사용자를 추출
                userId = Jwts.parser()
                        .setSigningKey(environment.getProperty("token.secret"))
                        .parseClaimsJws(token)
                        .getBody()
                        .getSubject();
            }
        } catch (Exception e) {
            System.out.println("Invalid token: " + e.getMessage());
        }

        return userId;
    }
}
