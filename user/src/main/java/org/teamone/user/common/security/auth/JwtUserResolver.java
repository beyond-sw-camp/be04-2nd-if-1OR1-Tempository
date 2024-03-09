package org.teamone.user.common.security.auth;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class JwtUserResolver {

    private final Environment environment;

    @Autowired
    public JwtUserResolver(Environment environment) {
        this.environment = environment;
    }

    public String resolveUserFromToken(String token) {
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

    public String resolveUserFromTokenForUser(String token) {
        String userId = null;

        try {
            if (token != null) {
                // 토큰을 검증하고 페이로드에서 사용자를 추출
                userId = Jwts.parser()
                        .setSigningKey(environment.getProperty("token.secret"))
                        .parseClaimsJws(token.replace("Bearer ", ""))
                        .getBody()
                        .getSubject();
            }
        } catch (Exception e) {
            System.out.println("Invalid token: " + e.getMessage());
        }

        return userId;
    }
}
